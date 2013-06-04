package cn.itcast.bbs.web.struts.formbean;

import cn.itcast.bbs.web.struts.formbean.base.ActionFormBase;

@SuppressWarnings("serial")
public class TopicSearchActionForm extends ActionFormBase {
	private String queryString;

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

}
