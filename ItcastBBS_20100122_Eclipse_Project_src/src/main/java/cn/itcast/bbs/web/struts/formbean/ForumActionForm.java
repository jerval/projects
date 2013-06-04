package cn.itcast.bbs.web.struts.formbean;

import cn.itcast.bbs.web.struts.formbean.base.ActionFormBase;

/**
 * @author 传智播客.汤阳光 Jul 7, 2008
 */
@SuppressWarnings("serial") public class ForumActionForm extends ActionFormBase {
	private String id;
	private String name;
	private String description;
	private String categoryId;

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

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}
