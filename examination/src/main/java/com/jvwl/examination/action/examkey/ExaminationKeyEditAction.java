package com.jvwl.examination.action.examkey;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.ExaminationKey;
import com.jvwl.examination.service.IExaminationKeyService;
import com.opensymphony.xwork2.ModelDriven;

@Component("examinationKeyEditAction")
@SuppressWarnings("serial")
public class ExaminationKeyEditAction extends BaseAction implements
		ModelDriven<ExaminationKey> {

	private IExaminationKeyService<ExaminationKey> examinationKeyService;
	private ExaminationKey examinationKey = new ExaminationKey();
	private String[] ids;
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@Resource
	public void setExaminationKeyService(IExaminationKeyService<ExaminationKey> examinationKeyService) {
		this.examinationKeyService = examinationKeyService;
	}

	public ExaminationKey getExaminationKey() {
		return examinationKey;
	}

	@JSON(serialize = false)
	@Override
	public String execute() throws Exception {
		return "login";
	}

	@JSON(serialize = false)
	public String update() throws Exception {
		examinationKey = examinationKeyService.findClass(ExaminationKey.class, examinationKey.getId());
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String delete() throws Exception {
		Boolean state = true;
		for (String id : ids) {
			try {
				examinationKeyService.delete(examinationKeyService.find(ExaminationKey.class, Integer.parseInt(id)));
			} catch (BusinessException e) {
				state = false;
				e.printStackTrace();
			}
		}
		if (state) {
			message = new Message("删除数据成功！", true, null);
		} else {
			message = new Message("删除数据失败！！！\n部分数据删除时发生异常", false, null);
		}
		return SUCCESS;
	}

	@Override
	@JSON(serialize = false)
	public ExaminationKey getModel() {
		return examinationKey;
	}
}
