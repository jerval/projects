package cn.itcast.bbs.service.impl;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bbs.domain.Forum;
import cn.itcast.bbs.domain.Reply;
import cn.itcast.bbs.domain.SearchableTopic;
import cn.itcast.bbs.domain.Topic;
import cn.itcast.bbs.domain.User;
import cn.itcast.bbs.service.ReplyService;
import cn.itcast.bbs.service.base.ServiceImplBase;

/**
 * @author 传智播客.汤阳光 Apr 9, 2008
 */
@Service("replyService")
@Transactional
public class ReplyServiceImpl extends ServiceImplBase<Reply> implements ReplyService {

	@Override
	public void save(Reply reply) {
		Topic topic = reply.getTopic();

		// 设置楼层
		// 第一个回复是1楼,以后的回复楼层数递增
		reply.setFloor(topic.getNextFloor());

		// 保存 reply
		getSession().persist(reply);

		// 更新Topic相关信息
		topic.setLastReply(reply);
		topic.setReplyCount(topic.getReplyCount() + 1);
		topic.setNextFloor(topic.getNextFloor() + 1);
		topic.setLastArticlePostTime(reply.getPostTime());
		getSession().merge(topic);

		// 更新Forum相关信息
		Forum forum = topic.getForum();
		forum.setArticleCount(forum.getArticleCount() + 1);
		forum.setLastArticlePostTime(reply.getPostTime());
		getSession().merge(forum);

		// 更新作者相关信息
		User author = reply.getAuthor();
		author.setArticleCount(author.getArticleCount() + 1);
		getSession().merge(author);

		// FIXME 保存附件(如果有) ，发表新回复时不会带有附件，附件是单独添加的
		// if (p.getAttachments().size() > 0) {
		// AttachmentHelper.storeAttachments(p.getAttachments());
		// }

		// 更新Topic索引（更新了最后更新时间、回复数量）
		topicIndexDao.update(new SearchableTopic(topic));
	}

	@Override
	public void delete(Serializable id) {
		Reply reply = (Reply) getSession().get(Reply.class, id);
		Topic topic = reply.getTopic();
		Forum forum = topic.getForum();

		// 先把topic.lastReply设为null才可以。否则会因为引用，被再次保存
		topic.setLastReply(null);
		// getSession().delete(reply); // 不使用真正的删除
		reply.setDeleted(true); // 标记为已删除就可以了
		getSession().merge(reply);
		getSession().flush();

		// 更新Topic的相关信息
		Reply lastReplyInTopic = findLastReplyInTopic(topic);
		// 如果删除的是最后一个回复, 则最后文章发表的时间就是主帖发表的时间了
		Date lastArticleInTopicPostTime = (lastReplyInTopic == null) ? topic.getPostTime() : lastReplyInTopic.getPostTime();

		topic.setLastReply(lastReplyInTopic);
		topic.setReplyCount(topic.getReplyCount() - 1);
		topic.setLastArticlePostTime(lastArticleInTopicPostTime);
		getSession().merge(topic);

		// Update forum's information
		forum.setArticleCount(forum.getArticleCount() - 1);
		forum.setLastArticlePostTime(getLastArticlePostTimeInForum(forum));
		getSession().merge(forum);

		// Update author's information
		User author = reply.getAuthor();
		author.setArticleCount(author.getArticleCount() - 1);
		getSession().merge(author);

		// FIXME 做日志 log
		// OperationLog olog = new OperationLog();
		// olog.setComment(reason);
		// olog.setEntityId(reply.getId());
		// olog.setEntityType(Reply.class);
		// olog.setLogTime(new Date());
		// olog.setOperator(ExecutionContext.get().getLoggedOnUser());
		// olog.setOperIpAddr(ExecutionContext.get().getIpAddr());
		// olog.setType(OperationLogType.DELETE_REPLY);

		// FIXME delete attachments 应是只做删除标记?
		// AttachmentHelper.deleteAttachmentFiles(reply.getAttachments());

		 // Update Topic's index（修改了回复数与最后回复时间）
		 topicIndexDao.update(new SearchableTopic(topic));
	}

	
	private Date getLastArticlePostTimeInForum(Forum forum) {
		return (Date) getSession().createCriteria(Topic.class)//
				.add(Restrictions.eq("forum", forum))//
				.add(Restrictions.eq("deleted", false))//
				.setProjection(Projections.max("lastArticlePostTime"))//
				.uniqueResult();
	}
	/**
	 * 查询主题中的最后一个回复
	 * 
	 * @param topic
	 * @return
	 */
	private Reply findLastReplyInTopic(Topic topic) {
		return (Reply) getSession().createCriteria(Reply.class)//
				.add(Restrictions.eq("topic", topic))//
				.add(Restrictions.eq("deleted", false))//
				.addOrder(Order.desc("postTime"))//
				.setFirstResult(0)//
				.setMaxResults(1)//
				.uniqueResult();
	}
}
