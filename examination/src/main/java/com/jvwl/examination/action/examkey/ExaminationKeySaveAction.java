package com.jvwl.examination.action.examkey;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.ExaminationKey;
import com.jvwl.examination.model.ExaminationQuestion;
import com.jvwl.examination.service.IExaminationKeyService;
import com.jvwl.examination.service.IExaminationQuestionService;
import com.opensymphony.xwork2.ModelDriven;

@Component("examinationKeySaveAction")
@SuppressWarnings("serial")
public class ExaminationKeySaveAction extends BaseAction implements
		ModelDriven<ExaminationKey> {

	private IExaminationKeyService<ExaminationKey> examinationKeyService;
	private IExaminationQuestionService<ExaminationQuestion> examinationQuestionService;
	private ExaminationKey examinationKey = new ExaminationKey();
	private Message message;

	public Message getMessage() {
		return message;
	}

	@Resource
	public void setExaminationQuestionService(
			IExaminationQuestionService<ExaminationQuestion> examinationQuestionService) {
		this.examinationQuestionService = examinationQuestionService;
	}

	@Resource
	public void setExaminationKeyService(
			IExaminationKeyService<ExaminationKey> examinationKeyService) {
		this.examinationKeyService = examinationKeyService;
	}

	@JSON(serialize = false)
	@Override
	public String execute() throws Exception {
		return "login";
	}

	@JSON(serialize = false)
	public String editSave() throws Exception {
		try {
			ExaminationQuestion examQuestion = examinationQuestionService.findClass(
					ExaminationQuestion.class, examinationKey.getQuestion().getId());
			if (examQuestion == null) {
				throw new BusinessException(
						"所选试题不存在！<br/>可能已被别人删除，请刷新后再试，由此带来的不便敬请谅解！");
			}
			ExaminationKey examKey = examinationKeyService.findClass(
					ExaminationKey.class, examinationKey.getId());
			examKey.setContent(examinationKey.getContent());
			examKey.setCorrect(examinationKey.getCorrect());
			examKey.setQuestion(examQuestion);
			examKey.setState(examinationKey.getState());
			examKey.setVersion(examinationKey.getVersion());
			examinationKeyService.update(examKey);
			message = new Message("修改试题答案信息成功！", true, "exam_key_list.html");
		} catch (RuntimeException e) {
			e.printStackTrace();
			message = new Message("修改试题答案信息失败，请重试！<br/>原因：" + e.getMessage(),
					false, null);
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public String addSave() throws Exception {
		System.out.println(111);
		try {
			ExaminationQuestion examinationQuestion = examinationQuestionService.findClass(
					ExaminationQuestion.class, examinationKey.getQuestion().getId());
			if (examinationQuestion == null) {
				throw new BusinessException(
						"所选试题不存在！<br/>可能已被别人删除，请刷新后再试，由此带来的不便敬请谅解！");
			}
			examinationKey.setQuestion(examinationQuestion);
			examinationKeyService.save(examinationKey);
			message = new Message("添加试题答案信息成功！", true, "exam_key_list.html");
		} catch (RuntimeException e) {
			e.printStackTrace();
			message = new Message("添加试题答案信息失败，请重试！<br/>原因：" + e.getMessage(),
					false, null);
		}
		return SUCCESS;
	}

	@Override
	@JSON(serialize = false)
	public ExaminationKey getModel() {
		return examinationKey;
	}
}
