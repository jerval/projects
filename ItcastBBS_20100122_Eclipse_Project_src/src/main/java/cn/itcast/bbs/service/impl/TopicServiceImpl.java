package cn.itcast.bbs.service.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bbs.domain.Forum;
import cn.itcast.bbs.domain.SearchableTopic;
import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.service.TopicService;
import cn.itcast.bbs.service.base.ServiceImplBase;

/**
 * @author 传智播客.汤阳光 Dec 15, 2008
 */
@Service("topicService")
@Transactional
@SuppressWarnings("unchecked")
public class TopicServiceImpl extends ServiceImplBase<Topic> implements TopicService {

	@Override
	public Topic getById(Serializable id) {
		Topic topic = (Topic) getSession().get(Topic.class, id);
		if (topic != null && topic.isDeleted()) {
			topic = null;
		}
		return topic;
	}

	@Override
	public List<Topic> getByIdList(Serializable[] idList) {
		if (idList == null || idList.length == 0) {
			return Collections.EMPTY_LIST;
		}

		return getSession().createCriteria(getEntityName())//
				.add(Restrictions.in("id", idList))//
				.add(Restrictions.eq("deleted", false))//
				.list();
	}

	@Override
	public int getCount() {
		return ((Number) getSession().createCriteria(getEntityName())//
				.add(Restrictions.eq("deleted", false))//
				.setProjection(Projections.rowCount())//
				.uniqueResult())//
				.intValue();
	}

	@Override
	public void save(Topic topic) {
		// 1, save topic
		topic.setNextFloor(1);
		topic.setLastArticlePostTime(topic.getPostTime());
		getSession().persist(topic);// Save topic

		// 2, 更新相关信息
		Forum forum = topic.getForum();
		forum.setLastTopic(topic);
		forum.setLastArticlePostTime(topic.getPostTime());
		forum.setTopicCount(forum.getTopicCount() + 1);
		forum.setArticleCount(forum.getArticleCount() + 1);
		getSession().merge(forum); // Update forum

		// user
		User author = topic.getAuthor();
		author.setTopicCount(author.getTopicCount() + 1);
		author.setArticleCount(author.getArticleCount() + 1);
		getSession().merge(author); // Update user

		// FXIME 保存附件(如果有), 在哪里保存
		// AttachmentHelper.storeAttachmentFiles(topic.getAttachments());

		// FIXME 建立索引
		topicIndexDao.save(new SearchableTopic(topic));
	}

	@Override
	public void update(Topic topic) {
		getSession().merge(topic);
		// FIXME 更新索引
		topicIndexDao.update(new SearchableTopic(topic));
	}

	@Override
	public void delete(Serializable id) {
		Topic topic = (Topic) getSession().get(Topic.class, id);
		Forum forum = topic.getForum();
		// set deleted
		topic.setDeleted(true);
		getSession().merge(topic);
		getSession().flush();

		//
		forum.setLastTopic(null);
		// FIXME 放这里就抛异常？failed to lazily initialize a collection, no session or session was closed
		// 出错行为: AttachmentHelper.deleteAttachmentFiles(topic.getAttachments());
		// 把他放到最后就不报错了
		// topicDao.delete(topic); // Delete topic

		// 主题中包含的文章的数量,为回复数加1,因为还有一个主帖.
		int totalArticlesInTopic = topic.getReplyCount() + 1;
		Topic lastTopicInForum = findLastTopicByForum(forum);

		// 更新Forum的有关信息
		forum.setTopicCount(forum.getTopicCount() - 1);
		forum.setArticleCount(forum.getArticleCount() - totalArticlesInTopic);
		forum.setLastTopic(lastTopicInForum);
		forum.setLastArticlePostTime(getLastArticlePostTimeInForum(forum));
		getSession().merge(forum);

		// 更新作者的有关信息
		User author = topic.getAuthor();
		author.setTopicCount(author.getTopicCount() - 1);
		author.setArticleCount(author.getArticleCount() - totalArticlesInTopic);
		getSession().merge(author);

		// // log FIXME 做日志
		// OperationLog olog = new OperationLog();
		// olog.setEntityId(topic.getId());
		// olog.setEntityType(Topic.class);
		// olog.setLogTime(new Date());
		// olog.setOperator(ExecutionContext.get().getLoggedOnUser());
		// olog.setOperIpAddr(ExecutionContext.get().getIpAddr());
		// olog.setType(OperationLogType.DELETE_TOPIC);
		// super.save(olog);

		// 删除附件文件
		// AttachmentHelper.deleteAttachmentFiles(topic.getAttachments());
		// for (Reply r : topic.getReplies()) {
		// AttachmentHelper.deleteAttachmentFiles(r.getAttachments());
		// }

		// 删除索引
		topicIndexDao.delete(topic.getId());
	}

	private Date getLastArticlePostTimeInForum(Forum forum) {
		return (Date) getSession().createCriteria(Topic.class)//
				.add(Restrictions.eq("forum", forum))//
				.add(Restrictions.eq("deleted", false))//
				.setProjection(Projections.max("lastArticlePostTime"))//
				.uniqueResult();
	}

	/**
	 * @param forum
	 * @return
	 */
	private Topic findLastTopicByForum(Forum forum) {
		return (Topic) getSession().createCriteria(Topic.class)//
				.add(Restrictions.eq("forum", forum))//
				.add(Restrictions.eq("deleted", false))//
				.addOrder(Order.desc("postTime"))//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
		// String queryString = "from Topic t where t.id = (select max(t2.postTime) from Topic t2 where t2.forum=?)";
	}

	public void move(String id, String destForumId) {
		Topic topic = (Topic) getSession().get(Topic.class, id);
		Forum sourceForum = topic.getForum(); // 原版面
		Forum destForum = (Forum) getSession().get(Forum.class, destForumId); // 目标版面

		// Update
		topic.setForum(destForum);
		getSession().merge(topic);
		getSession().flush();

		// 主题中包含的文章的数量,为回复数加1,因为还有一个主帖.
		int totalArticlesInTopic = topic.getReplyCount() + 1;

		// 更新原版面的信息
		sourceForum.setTopicCount(sourceForum.getTopicCount() - 1); // topic count
		sourceForum.setArticleCount(sourceForum.getArticleCount() - totalArticlesInTopic);
		sourceForum.setLastTopic(findLastTopicByForum(sourceForum));
		sourceForum.setLastArticlePostTime(getLastArticlePostTimeInForum(sourceForum));
		getSession().merge(sourceForum);
		// FIXME 一定要flush()一下，否则会有异常：java.sql.BatchUpdateException: Duplicate entry 'ff808081264f60f901264f658ff60003' for key 2
		// 应该是因为最后一起被flush()，本条update放在了下面的生成的update语句后，就会违反unique约束
		getSession().flush();

		// 更新目标版面的信息
		destForum.setTopicCount(destForum.getTopicCount() + 1); // topic count
		destForum.setArticleCount(destForum.getArticleCount() + totalArticlesInTopic);
		destForum.setLastTopic(findLastTopicByForum(destForum));
		destForum.setLastArticlePostTime(getLastArticlePostTimeInForum(destForum));
		getSession().merge(destForum);

		// FIXME 做日志
		// OperationLog olog = new OperationLog();
		// olog.setComment(reason);
		// olog.setEntityId(topic.getId());
		// olog.setEntityType(Topic.class);
		// olog.setLogTime(new Date());
		// olog.setOperator(ExecutionContext.get().getLoggedOnUser());
		// olog.setOperIpAddr(ExecutionContext.get().getIpAddr());
		// olog.setType(OperationLogType.MOVE_TOPICS);
		// super.save(olog);

		// 更新索引
		topicIndexDao.update(new SearchableTopic(topic));
	}

}
