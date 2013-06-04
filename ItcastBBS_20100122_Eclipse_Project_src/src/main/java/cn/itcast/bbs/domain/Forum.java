package cn.itcast.bbs.domain;

import java.util.Date;

/**
 * 版面(二级版面)
 * 
 * @author 传智博客.汤阳光 Jun 19, 2008
 */
public class Forum {
	private String id;
	private String name;// 名称
	private String description;// 描述
	private Category category;// 所属的分类
	private int order;// 显示顺序

	private int topicCount;// 总主题数量
	private int articleCount;// 总文章数量
	private Topic lastTopic;// 最后发表的文章
	private Date lastArticlePostTime; // 最后一个文章（主题或回复）发表的时间（或叫最后更新）

	public Forum() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getTopicCount() {
		return topicCount;
	}

	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public Topic getLastTopic() {
		return lastTopic;
	}

	public void setLastTopic(Topic lastTopic) {
		this.lastTopic = lastTopic;
	}

	public Date getLastArticlePostTime() {
		return lastArticlePostTime;
	}

	public void setLastArticlePostTime(Date lastArticlePostTime) {
		this.lastArticlePostTime = lastArticlePostTime;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("[Forum: ")//
				.append("id=").append(id)//
				.append(",name=").append(name)//
				.append(",description=").append(description)//
				.append(",topicCount=").append(topicCount)//
				.append(",articleCount=").append(articleCount)//
				.append("]")//
				.toString();
	}

}
