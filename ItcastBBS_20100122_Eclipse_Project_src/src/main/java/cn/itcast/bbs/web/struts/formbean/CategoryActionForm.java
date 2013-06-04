package cn.itcast.bbs.web.struts.formbean;

import cn.itcast.bbs.web.struts.formbean.base.ActionFormBase;

/**
 * 
 * @author 传智播客.汤阳光 Dec 15, 2008
 */
@SuppressWarnings("serial") public class CategoryActionForm extends ActionFormBase {
	private String id;
	private String name;

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
}
