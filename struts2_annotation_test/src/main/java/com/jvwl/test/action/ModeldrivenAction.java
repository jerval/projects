package com.jvwl.test.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.jvwl.test.model.User;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.After;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@SuppressWarnings("serial")
public class ModeldrivenAction extends BaseAction implements ModelDriven<User> {
	private User user = new User();

	@Override
	@Action("modeldriven")
	@InputConfig(methodName = "fail")
	@Validations(stringLengthFields = { @StringLengthFieldValidator(fieldName = "username", minLength = "1", maxLength = "2", type = ValidatorType.SIMPLE, trim = true, message = "用户名不输入不正确！") })
	public String execute() throws Exception {
		System.out.println("00000000000000000000000000");
		System.out.println(getText("jerval"));
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/images");
		System.out.println(realpath);
		if (user.getImage() != null) {
			File savedir = new File(realpath);
			if (!savedir.exists())
				savedir.mkdirs();
			for (int i = 0; i < user.getImage().length; i++) {
				File savefile = new File(new File(realpath), user
						.getImageFileName()[i]);
				FileUtils.copyFile(user.getImage()[i], savefile);
			}
		}
		return SUCCESS;
	}

	@Action("save")
	@Validations(stringLengthFields = { @StringLengthFieldValidator(fieldName = "id", minLength = "1", maxLength = "2", type = ValidatorType.SIMPLE, trim = true, message = "ID不输入不正确！") })
	public String add() throws Exception {
		System.out.println("tt");
		return SUCCESS;
	}

	public String fail() {
		System.out.println("fail method");
		return "input";
	}

	public User getModel() {
		return user;
	}

	@Before
	public void fun1() {
		System.out.println("fun1 method");
	}

	@After
	public void fun2() {
		System.out.println("fun2 method");
	}

	@BeforeResult
	public void isValid() throws ValidationException {
		System.out.println("isValid method");
	}

	@BeforeResult
	public void fun3() {
		System.out.println("fun5 method");
	}
}
