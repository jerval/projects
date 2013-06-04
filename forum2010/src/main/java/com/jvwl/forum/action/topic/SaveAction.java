package com.jvwl.forum.action.topic;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import com.jvwl.forum.action.base.BaseAction;
import com.jvwl.forum.common.Message;
import com.jvwl.forum.exception.BusinessException;
import com.jvwl.forum.model.Topic;
import com.jvwl.forum.service.TopicService;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

@SuppressWarnings("serial")
public class SaveAction extends BaseAction implements ModelDriven<Topic> {

	private TopicService topicService;
	private Topic topic = new Topic();
	private Message message;

	public Message getMessage() {
		return message;
	}

	@Resource
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public String fail() {
		System.out.println(this.getFieldErrors().values());
		message = new Message(getText("operate_fail"), "添加部门信息失败，请重试！<br/>原因："
				+ this.getFieldErrors().values(), false, null);
		return SUCCESS;
	}

	@JSON(serialize = false)
	@Override
	@InputConfig(methodName = "fail")
	@Validations(regexFields = {
			@RegexFieldValidator(fieldName = "depart_id", message = "编号格式不正确", expression = "^(\\w){4,20}$"),
			@RegexFieldValidator(fieldName = "depart_name", message = "名称格式不正确", expression = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$") })
	public String execute() throws Exception {
		if (topic.getId() == null) {
			try {
				topicService.save(topic);
				message = new Message(getText("operate_ok"), "添加部门信息成功！", true,
						"topic_list");
			} catch (BusinessException e) {
				e.printStackTrace();
				message = new Message(getText("operate_fail"),
						"添加部门信息失败，请重试！<br/>原因：" + e.getMessage(), false, null);
			}
		} else {
			try {
				topicService.update(topic);
				message = new Message(getText("operate_ok"), "修改部门信息成功！", true,
						"topic_list");
			} catch (BusinessException e) {
				e.printStackTrace();
				message = new Message(getText("operate_ok"),
						"修改部门信息失败，请重试！<br/>原因：" + e.getMessage(), false, null);
			}
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public Topic getModel() {
		return topic;
	}
}
