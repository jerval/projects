package com.jvwl.test.action;

import com.jvwl.test.model.User;
import com.opensymphony.xwork2.conversion.annotations.ConversionType;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@SuppressWarnings("serial")
// @Conversion()
public class TestAction extends BaseAction {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	@TypeConversion(type = ConversionType.CLASS, key = "user.birthday", converter = "com.jvwl.test.converter.DateConverter")
	@Validations(stringLengthFields = { @StringLengthFieldValidator(fieldName = "user.username", minLength = "1", maxLength = "2", type = ValidatorType.SIMPLE, trim = true, message = "username is not correct!")})
	public String execute() throws Exception {
		System.out.println("00000000000000000000000000");
		System.out.println(user.getBirthday());
		System.out.println(this.getActionErrors().toArray());
		return SUCCESS;
	}

}
