package com.jvwl.dto;

import com.jvwl.model.User;

public class UserDTO extends User {
	private String comfirmPass;

	public String getComfirmPass() {
		return comfirmPass;
	}

	public void setComfirmPass(String comfirmPass) {
		this.comfirmPass = comfirmPass;
	}

}
