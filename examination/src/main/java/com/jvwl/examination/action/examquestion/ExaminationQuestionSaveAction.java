package com.jvwl.examination.action.examquestion;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.ExaminationPaper;
import com.jvwl.examination.model.ExaminationQuestion;
import com.jvwl.examination.service.IExaminationPaperService;
import com.jvwl.examination.service.IExaminationQuestionService;
import com.opensymphony.xwork2.ModelDriven;

@Component("examinationQuestionSaveAction")
@SuppressWarnings("serial")
public class ExaminationQuestionSaveAction extends BaseAction implements
		ModelDriven<ExaminationQuestion> {

	private IExaminationQuestionService<ExaminationQuestion> examinationQuestionService;
	private IExaminationPaperService<ExaminationPaper> examinationPaperService;
	private ExaminationQuestion examinationQuestion = new ExaminationQuestion();
	private Message message;

	public Message getMessage() {
		return message;
	}

	@Resource
	public void setExaminationPapertService(
			IExaminationPaperService<ExaminationPaper> examinationPaperService) {
		this.examinationPaperService = examinationPaperService;
	}

	@Resource
	public void setExaminationQuestionService(
			IExaminationQuestionService<ExaminationQuestion> examinationQuestionService) {
		this.examinationQuestionService = examinationQuestionService;
	}

	@JSON(serialize = false)
	@Override
	public String execute() throws Exception {
		return "login";
	}

	@JSON(serialize = false)
	public String editSave() throws Exception {
		try {
			ExaminationPaper examPaper = examinationPaperService.findClass(
					ExaminationPaper.class, examinationQuestion.getPaper()
							.getId());
			if (examPaper == null) {
				throw new BusinessException(
						"所选部门不存在！<br/>可能已被别人删除，请刷新后再试，由此带来的不便敬请谅解！");
			}
			ExaminationQuestion examQuestion = examinationQuestionService
					.findClass(ExaminationQuestion.class, examinationQuestion
							.getId());
			examQuestion.setQuestion_id(examinationQuestion.getQuestion_id());
			examQuestion.setPaper(examPaper);
			examQuestion.setContent(examinationQuestion.getContent());
			examQuestion.setQuestionType(examinationQuestion.getQuestionType());
			examQuestion.setScore(examinationQuestion.getScore());
			examQuestion.setState(examinationQuestion.getState());
			examQuestion.setVersion(examinationQuestion.getVersion());
			examinationQuestionService.update(examQuestion);
			message = new Message("修改试卷信息成功！", true,
					"exam_question_list.html");
		} catch (RuntimeException e) {
			e.printStackTrace();
			message = new Message("修改试卷信息失败，请重试！<br/>原因：" + e.getMessage(),
					false, null);
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String addSave() throws Exception {
		try {
			ExaminationPaper examPaper = examinationPaperService.findClass(
					ExaminationPaper.class, examinationQuestion.getPaper()
							.getId());
			if (examPaper == null) {
				throw new BusinessException(
						"所选试卷不存在！<br/>可能已被别人删除，请刷新后再试，由此带来的不便敬请谅解！");
			}
			examinationQuestion.setPaper(examPaper);
			examinationQuestionService.save(examinationQuestion);
			message = new Message("添加试卷信息成功！", true,
					"exam_question_list.html");
		} catch (RuntimeException e) {
			e.printStackTrace();
			message = new Message("添加试卷信息失败，请重试！<br/>原因：" + e.getMessage(),
					false, null);
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	@Override
	public ExaminationQuestion getModel() {
		return examinationQuestion;
	}
}
