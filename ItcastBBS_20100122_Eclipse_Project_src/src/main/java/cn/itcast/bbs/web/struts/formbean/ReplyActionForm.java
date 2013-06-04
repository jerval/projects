package cn.itcast.bbs.web.struts.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import cn.itcast.bbs.web.struts.formbean.base.ActionFormBase;

@SuppressWarnings("serial")
public class ReplyActionForm extends ActionFormBase {
	private String id;
	private String topicId;
	private String title;
	private String content;

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (StringUtils.isBlank(content) || content.trim().length() < 10) {
			errors.add("content", new ActionMessage("请输入内容，最小长度10个字符", false));
		} else if (content.length() > 65535) {
			errors.add("content", new ActionMessage("内容太长，最大长度65535个字符", false));
		}
		return errors;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
