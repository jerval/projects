package com.jvwl.test.model;

public class Sc {

	private Integer id;
	private String s_id;
	private String c_id;
	private Float sc_score;
	private String sc_memo;

	public Float getSc_score() {
		return sc_score;
	}

	public void setSc_score(Float scScore) {
		sc_score = scScore;
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

	public String getSc_memo() {
		return sc_memo;
	}

	public void setSc_memo(String scMemo) {
		sc_memo = scMemo;
	}

	@Override
	public String toString() {
		return "Sc [c_id=" + c_id + ", id=" + id + ", s_id=" + s_id
				+ ", sc_memo=" + sc_memo + "]";
	}

}
