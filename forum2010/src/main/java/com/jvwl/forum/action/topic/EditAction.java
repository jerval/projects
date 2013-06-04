package com.jvwl.forum.action.topic;

import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.json.annotations.JSON;
import com.jvwl.forum.action.base.BaseAction;
import com.jvwl.forum.common.Message;
import com.jvwl.forum.model.Topic;
import com.jvwl.forum.service.TopicService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class EditAction extends BaseAction implements ModelDriven<Topic> {

	private TopicService topicService;
	private Topic topic = new Topic();
	private String[] ids;
	private Message message;

	public Message getMessage() {
		return message;
	}

	@Resource
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@JSON(serialize = false)
	@Action("update")
	public String update() throws Exception {
		topic = topicService.findClassById(topic.getId());
		return SUCCESS;
	}

	@JSON(serialize = false)
	@Action("delete")
	public String delete() throws Exception {
		try {
			topicService.delete(ids);
			message = new Message(getText("operate_ok"), "删除数据成功！", true, null);
		} catch (Exception e) {
			message = new Message(getText("operate_fail"),
					"删除数据失败！！！\n部分数据删除时发生异常", false, null);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public Topic getModel() {
		return topic;
	}
}
