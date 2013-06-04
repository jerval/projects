package com.jvwl.examination.action.exampaper;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.ExaminationPaper;
import com.jvwl.examination.service.IExaminationPaperService;
import com.opensymphony.xwork2.ModelDriven;

@Component("examinationPaperEditAction")
@SuppressWarnings("serial")
public class ExaminationPaperEditAction extends BaseAction implements
		ModelDriven<ExaminationPaper> {

	private IExaminationPaperService<ExaminationPaper> examinationPaperService;
	private ExaminationPaper examinationPaper = new ExaminationPaper();
	private String[] ids;
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@Resource
	public void setExaminationPaperService(IExaminationPaperService<ExaminationPaper> examinationPaperService) {
		this.examinationPaperService = examinationPaperService;
	}

	public ExaminationPaper getExaminationPaper() {
		return examinationPaper;
	}

	@JSON(serialize = false)
	@Override
	public String execute() throws Exception {
		return "login";
	}

	@JSON(serialize = false)
	public String update() throws Exception {
		examinationPaper = examinationPaperService.findClass(ExaminationPaper.class, examinationPaper.getId());
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String delete() throws Exception {
		Boolean state = true;
		for (String id : ids) {
			try {
				examinationPaperService.delete(examinationPaperService.find(ExaminationPaper.class, Integer.parseInt(id)));
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
	public ExaminationPaper getModel() {
		return examinationPaper;
	}
}
