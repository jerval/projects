package cn.itcast.bbs.domain;

import java.util.Date;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

/**
 * 主题
 * 
 * @author 传智博客.汤阳光 Jun 19, 2008
 */
@Searchable
public class Topic extends Article {
	private String type;// 类型
	private Forum forum;// 所属版面
	private String summary; // 摘要信息（目前只有头条用）

	private int viewCount;// 查看次数
	private int replyCount;// 回复数量
	private Reply lastReply;// 最后回复

	private int nextFloor; // 记录下一个回复的楼层，解决楼层问题
	private Date lastArticlePostTime;// 本主题中的最后一个文章发表的时间, 用于显示文章列表时的排序

	public Topic() {
	}

	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
	public String getType() {
		return type;
	}

	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES, converter = "forumConverter")
	public Forum getForum() {
		return forum;
	}

	public int getViewCount() {
		return viewCount;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public Reply getLastReply() {
		return lastReply;
	}

	public int getNextFloor() {
		return nextFloor;
	}

	public Date getLastArticlePostTime() {
		return lastArticlePostTime;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}

	public void setNextFloor(int nextFloor) {
		this.nextFloor = nextFloor;
	}

	public void setLastArticlePostTime(Date lastArticlePostTime) {
		this.lastArticlePostTime = lastArticlePostTime;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
