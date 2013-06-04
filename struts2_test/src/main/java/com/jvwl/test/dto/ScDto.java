package com.jvwl.test.dto;

public class ScDto {
	private Integer id;
	private String s_id;
	private String c_id;
	private Float score1;
	private Float score2;

	public Float getScore1() {
		return score1;
	}

	public void setScore1(Float score1) {
		this.score1 = score1;
	}

	public Float getScore2() {
		return score2;
	}

	public void setScore2(Float score2) {
		this.score2 = score2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String sId) {
		s_id = sId;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String cId) {
		c_id = cId;
	}

	@Override
	public String toString() {
		return "ScDTO [c_id=" + c_id + ", id=" + id + ", s_id=" + s_id + "]";
	}

}
