package com.jvwl.model;

public class User {
	private String name;
	private UserType type = UserType.USER;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserType getType() {
		return type;
	}
	public String getTypeString() {
		return type.toString();
	}

	public void setType(UserType type) {
		this.type = type;
	}

}
