package com.jvwl.examination.action.exampaper;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.dto.Message;
import com.jvwl.examination.exception.BusinessException;
import com.jvwl.examination.model.Department;
import com.jvwl.examination.model.ExaminationPaper;
import com.jvwl.examination.service.IDepartmentService;
import com.jvwl.examination.service.IExaminationPaperService;
import com.opensymphony.xwork2.ModelDriven;

@Component("examinationPaperSaveAction")
@SuppressWarnings("serial")
public class ExaminationPaperSaveAction extends BaseAction implements
		ModelDriven<ExaminationPaper> {

	private IExaminationPaperService<ExaminationPaper> examinationPaperService;
	private IDepartmentService<Department> departmentService;
	private ExaminationPaper examinationPaper = new ExaminationPaper();
	private Message message;

	public Message getMessage() {
		return message;
	}

	@Resource
	public void setDepartmentService(
			IDepartmentService<Department> departmentService) {
		this.departmentService = departmentService;
	}

	@Resource
	public void setExaminationPaperService(
			IExaminationPaperService<ExaminationPaper> examinationPaperService) {
		this.examinationPaperService = examinationPaperService;
	}

	@JSON(serialize = false)
	@Override
	public String execute() throws Exception {
		return "login";
	}

	@JSON(serialize = false)
	public String editSave() throws Exception {
		try {
			Department dep = departmentService.findClass(Department.class,
					examinationPaper.getDepartment().getId());
			if (dep == null) {
				throw new BusinessException(
						"所选部门不存在！<br/>可能已被别人删除，请刷新后再试，由此带来的不便敬请谅解！");
			}System.out.println("------"+examinationPaper.getId());
			ExaminationPaper examPaper = examinationPaperService.findClass(ExaminationPaper.class, examinationPaper.getId());
			examPaper.setPaper_id(examinationPaper.getPaper_id());
			examPaper.setPaper_name(examinationPaper.getPaper_name());
			examPaper.setDepartment(dep);
			examPaper.setInfo(examinationPaper.getInfo());
			examPaper.setAnswerTime(examinationPaper.getAnswerTime());
			examPaper.setState(examinationPaper.getState());
			examPaper.setVersion(examinationPaper.getVersion());
			examinationPaperService.update(examPaper);
			message = new Message("修改试卷信息成功！", true,
					"exam_paper_list.html");
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
			Department dep = departmentService.findClass(Department.class,
					examinationPaper.getDepartment().getId());
			if (dep == null) {
				throw new BusinessException(
						"所选部门不存在！<br/>可能已被别人删除，请刷新后再试，由此带来的不便敬请谅解！");
			}
			examinationPaper.setDepartment(dep);
			examinationPaperService.save(examinationPaper);
			message = new Message("添加试卷信息成功！", true,
					"exam_paper_list.html");
		} catch (RuntimeException e) {
			e.printStackTrace();
			message = new Message("添加试卷信息失败，请重试！<br/>原因：" + e.getMessage(),
					false, null);
		}
		return SUCCESS;
	}

	@Override
	@JSON(serialize = false)
	public ExaminationPaper getModel() {
		return examinationPaper;
	}
}
