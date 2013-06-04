package com.jvwl.model;

public class Customer extends BaseBean{
	
	private String name;
	private String addr;
	private String cid;
	private UserType userType;

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Customer [addr=" + addr + ", cid=" + cid + ", name=" + name
				+ ", userType=" + userType + ", id=" + id + "]";
	}


}
