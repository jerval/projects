package cn.itcast.bbs.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.compass.annotations.Index;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

/**
 * 文章
 * 
 * @author 传智播客.汤阳光 Apr 25, 2009
 */
public abstract class Article {
	private String id;
	private String title; // 标题
	private String content;// 内容

	private User author;// 作者
	private Date postTime;// 发表时间
	private String ipAddr;// 发表文章时所用的IP地址
	private boolean deleted; // 是否已被删除

	private List<Attachment> attachments = new ArrayList<Attachment>(0); // 附件

	// private int editCount;// 编辑次数
	// private Date lastEditTime;// 最后编辑时间

	public Article() {
	}

	@SearchableId
	public String getId() {
		return id;
	}

	@SearchableProperty(index = Index.ANALYZED, store = Store.YES, boost = 2.0F)
	public String getTitle() {
		return title;
	}

	@SearchableProperty(index = Index.ANALYZED, store = Store.YES)
	public String getContent() {
		return content;
	}

	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
	public User getAuthor() {
		return author;
	}

	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
	public Date getPostTime() {
		return postTime;
	}

	@SearchableProperty(index = Index.NOT_ANALYZED, store = Store.YES)
	public String getIpAddr() {
		return ipAddr;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
