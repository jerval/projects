package com.jvwl.test.action.manage.sc;

import java.sql.SQLException;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import com.jvwl.test.action.BaseAction;
import com.jvwl.test.model.Sc;
import com.jvwl.test.service.ScService;
import com.opensymphony.xwork2.ModelDriven;

@Results( { @Result(name = "success", location = "/message.jsp"),
		@Result(name = "invalid.token", location = "/invalid_token.jsp") })
@InterceptorRefs( { @InterceptorRef("checkStack"), @InterceptorRef("token") })
@SuppressWarnings("serial")
public class SaveAction extends BaseAction implements ModelDriven<Sc> {

	private Sc sc = new Sc();
	private ScService scService = new ScService();

	@Override
	public String execute() throws Exception {
		if (sc.getId() == null) {
			try {
				scService.add(sc);
			} catch (SQLException e) {
				return "add";
			}

		} else {
			try {
				scService.update(sc);
			} catch (SQLException e) {
				return "update";
			}
		}
		addActionMessage("成绩信息操作成功！");
		return SUCCESS;
	}

	public Sc getModel() {
		return sc;
	}
}
