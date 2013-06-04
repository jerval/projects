package com.zk.spring.action;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;

import com.zk.spring.model.User;
import com.zk.spring.service.UserService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
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
	@WireVariable
	private UserService userService ;
	

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
    public void submit(){
        // omit irrelevant code for brevity
		userService.add(user);
    }

	/**
	 * ZK EL 内置对象。
	 * 
applicationScope
arg
componentScope
cookie
desktop
desktopScope
each
event
execution
header
headerValues
forEachStatus
labels
page
pageContext
pageScope
param
paramValues
requestScope
self
session
sessionScope
spaceOwner
spaceScope
zk
	 * 
	 */
}