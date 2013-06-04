package com.jvwl.examination.action.examquestion;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.ExaminationQuestion;
import com.jvwl.examination.service.IExaminationQuestionService;
import com.opensymphony.xwork2.ModelDriven;

@Component("examinationQuestionEditAction")
@SuppressWarnings("serial")
public class ExaminationQuestionEditAction extends BaseAction implements
		ModelDriven<ExaminationQuestion> {

	private IExaminationQuestionService<ExaminationQuestion> examinationQuestionService;
	private ExaminationQuestion examinationQuestion = new ExaminationQuestion();
	private String[] ids;
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	@Resource
	public void setExaminationQuestionService(IExaminationQuestionService<ExaminationQuestion> examinationQuestionService) {
		this.examinationQuestionService = examinationQuestionService;
	}

	public ExaminationQuestion getExaminationQuestion() {
		return examinationQuestion;
	}

	@JSON(serialize = false)
	@Override
	public String execute() throws Exception {
		return "login";
	}

	@JSON(serialize = false)
	public String update() throws Exception {
		examinationQuestion = examinationQuestionService.findClass(ExaminationQuestion.class, examinationQuestion.getId());
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String delete() throws Exception {
		Boolean state = true;
		for (String id : ids) {
			try {
				examinationQuestionService.delete(examinationQuestionService.find(ExaminationQuestion.class, Integer.parseInt(id)));
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
	public ExaminationQuestion getModel() {
		return examinationQuestion;
	}
}
