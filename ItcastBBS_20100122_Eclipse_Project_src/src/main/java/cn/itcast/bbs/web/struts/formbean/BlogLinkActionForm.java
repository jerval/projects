package cn.itcast.bbs.web.struts.formbean;

import cn.itcast.bbs.web.struts.formbean.base.ActionFormBase;

@SuppressWarnings("serial")
public class BlogLinkActionForm extends ActionFormBase {
	private String id;
	private String title;
	private String description;
	private String author;
	private String url;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
