package com.jvwl.dto;

public class DepartmentDTO {

	private String depart_id;// 部门ID
	private String depart_name;// 部门名称

	public DepartmentDTO(){}
	
	public DepartmentDTO(String departId, String departName) {
		depart_id = departId;
		depart_name = departName;
	}

	public String getDepart_id() {
		return depart_id;
	}

	public void setDepart_id(String departId) {
		depart_id = departId;
	}

	public String getDepart_name() {
		return depart_name;
	}

	public void setDepart_name(String departName) {
		depart_name = departName;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [depart_id=" + depart_id + ", depart_name="
				+ depart_name + "]";
	}


}
