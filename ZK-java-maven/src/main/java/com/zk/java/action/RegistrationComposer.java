package com.zk.java.action;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;

import com.zk.java.model.User;
import com.zk.java.service.UserService;

public class RegistrationComposer extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6540388769245984804L;

	@Wire
	private Button submitButton;

	@Wire
	private Checkbox acceptTermBox;
	private User user = new User();
	private UserService userService = new UserService();
	

	@Listen("onCheck = #acceptTermBox")
	public void changeSubmitStatus() {
		if (acceptTermBox.isChecked()) {
			submitButton.setDisabled(false);
			submitButton.setImage("/images/submit.png");
		} else {
			submitButton.setDisabled(true);
			submitButton.setImage("");
		}
	}

	@Listen("onClick = #submitButton")
	public void register() {
		System.out.println("============register==========");
		userService.add(user);
	}

}