package cn.itcast.bbs.domain;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.compass.annotations.ExcludeFromAll;
import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

import cn.itcast.bbs.utils.ArticleUtils;

@Searchable
public class SearchableTopic {
	@SearchableId
	private String id;
	@SearchableProperty(index = Index.ANALYZED, store = Store.YES)
	private String title; // 标题
	@SearchableProperty(index = Index.ANALYZED, store = Store.YES)
	private String content;// 内容
	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES, excludeFromAll = ExcludeFromAll.YES)
	private String type;// 类型
	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
	private int replyCount;// 回复数量
	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
	private Date lastArticlePostTime;

	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES, excludeFromAll = ExcludeFromAll.YES)
	private String authorId;// 作者id
	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES, excludeFromAll = ExcludeFromAll.YES)
	private String authorNickname;// 作者nickname
	@SearchableProperty(index = Index.NO, store = Store.YES)
	private String forumId;// 所属版面（如果索引版面名，则需要在修改版面信息时同时修改索引。可以索引id解决此问题）
	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES, excludeFromAll = ExcludeFromAll.YES)
	private String forumName;// 所属版面

	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES, excludeFromAll = ExcludeFromAll.YES)
	private Date postTime;// 发表时间
	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES, excludeFromAll = ExcludeFromAll.YES)
	private String ipAddr;// 发表文章时所用的IP地址

	public SearchableTopic() {
	}

	public SearchableTopic(Topic topic) {
		try {
			BeanUtils.copyProperties(this, topic);
			this.authorId = topic.getAuthor().getId();
			this.authorNickname = topic.getAuthor().getNickname();
			this.forumId = topic.getForum().getId();
			this.forumName = topic.getForum().getName();

			// FIXME 如果移除html标签后为长度为0，则在索引时，这个字段的值会被认为是null？(结果是这样，是Lucene做的，还是Compass？）
			// 所以，要求removeHtmlElements()方法把标签不能替换为空字符串，这里替换为全角空格
			this.content = ArticleUtils.removeHtmlElements(topic.getContent());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorNickname() {
		return authorNickname;
	}

	public void setAuthorNickname(String authorNickname) {
		this.authorNickname = authorNickname;
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public Date getLastArticlePostTime() {
		return lastArticlePostTime;
	}

	public void setLastArticlePostTime(Date lastArticlePostTime) {
		this.lastArticlePostTime = lastArticlePostTime;
	}

}
