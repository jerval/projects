package com.jvwl.test.action.manage.sc;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import com.jvwl.test.action.BaseAction;
import com.jvwl.test.model.Sc;
import com.jvwl.test.service.ScService;

@SuppressWarnings("serial")
public class EditAction extends BaseAction {

	private ScService scService = new ScService();
	private Sc sc;
	private Integer id;
	
	public Sc getSc() {
		return sc;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Action("add")
	public String add() throws Exception {
		return SUCCESS;
	}

	@Action("update")
	public String update() throws Exception {
		sc = scService.findScById(id);
		return SUCCESS;
	}

	@Action(value="delete",results={@Result(name = "success", location = "/message.jsp")})
	public String delete() throws Exception {
		scService.delete(id);
		addActionMessage("删除成功");
		return SUCCESS;
	}
	
	public Sc getModel() {
		return sc;
	}
}
