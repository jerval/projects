package com.jvwl.forum.action.topic;

import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.jvwl.forum.action.base.BaseAction;
import com.jvwl.forum.common.PageInfo;
import com.jvwl.forum.common.Pagination;
import com.jvwl.forum.dto.TopicDto;
import com.jvwl.forum.model.Topic;
import com.jvwl.forum.service.TopicService;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ListAction extends BaseAction implements SessionAware,
		ModelDriven<TopicDto> {

	private TopicService topicService;
	private TopicDto topicDto = new TopicDto();
	private Pagination<Topic> pagination;
	private Map<String, Object> sessionMap;
	private Integer pageNo;
	private Integer pageSize;

	@Resource
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public Pagination<Topic> getPagination() {
		return pagination;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	@JSON(serialize = false)
	public String execute() throws Exception {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (sessionMap.get("pageSize") == null) {
			sessionMap.put("pageSize", 10);
		} else if (pageSize != null) {
			sessionMap.put("pageSize", pageSize);
		}
		pagination = topicService.findTopics(topicDto,
				new PageInfo(pageNo, (Integer) sessionMap.get("pageSize")));
		return SUCCESS;
	}

	@JSON(serialize = false)
	public TopicDto getModel() {
		return topicDto;
	}

	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
