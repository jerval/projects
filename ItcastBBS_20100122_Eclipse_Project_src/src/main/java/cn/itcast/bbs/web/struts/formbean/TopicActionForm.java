package cn.itcast.bbs.web.struts.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import cn.itcast.bbs.web.struts.formbean.base.ActionFormBase;

@SuppressWarnings("serial")
public class TopicActionForm extends ActionFormBase {
	private String id;
	private String title;
	private String content;
	private String type = "普通";// TODO 贴子类型
	private String summary;
	private String forumId;

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (StringUtils.isBlank(title)) {
			errors.add("title", new ActionMessage("请输入标题", false));
		} else if (title.length() > 255) {
			errors.add("title", new ActionMessage("标题太长，最多允许255个字符", false));
		}
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
