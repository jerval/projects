package cn.itcast.bbs.web.struts.formbean;

import cn.itcast.bbs.web.struts.formbean.base.ActionFormBase;

@SuppressWarnings("serial")
public class RoleActionForm extends ActionFormBase {
	private String id;
	private String name; // 名称
	private String description;// 描述
	private String[] systemPrivilegeIdList = {};

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

	public String[] getSystemPrivilegeIdList() {
		return systemPrivilegeIdList;
	}

	public void setSystemPrivilegeIdList(String[] systemPrivilegeIdList) {
		this.systemPrivilegeIdList = systemPrivilegeIdList;
	}

}
