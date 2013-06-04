package com.jvwl.examination.action.front;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Component;

import com.jvwl.examination.action.BaseAction;
import com.jvwl.examination.bean.YesNo;
import com.jvwl.examination.dto.OperateEmployee;
import com.jvwl.examination.dto.PageInfo;
import com.jvwl.examination.dto.Pagination;
import com.jvwl.examination.model.Employee;
import com.jvwl.examination.model.ExaminationKey;
import com.jvwl.examination.model.ExaminationPaper;
import com.jvwl.examination.model.ExaminationQuestion;
import com.jvwl.examination.model.ExaminationScore;
import com.jvwl.examination.service.IEmployeeService;
import com.jvwl.examination.service.IExaminationPaperService;
import com.jvwl.examination.service.IExaminationQuestionService;
import com.jvwl.examination.service.IExaminationScoreService;

@Component("getExamAction")
@SuppressWarnings("serial")
public class GetExamAction extends BaseAction implements SessionAware {

	private IExaminationQuestionService<ExaminationQuestion> questionService;
	private IExaminationScoreService<ExaminationScore> examScoreService;
	private IExaminationPaperService<ExaminationPaper> examPaperService;
	private IEmployeeService<Employee> employeeService;
	private Pagination<ExaminationQuestion> pagination;
	private Map<String, Object> sessionMap;
	private String question_id;
	private Integer[] keys;
	private Integer[] selectKeys;
	private Integer pageNo;
	private Float score;
	private Boolean state = false;

	@JSON(serialize = false)
	public Boolean getState() {
		return state;
	}
	@Resource(name="examinationPaperService")
	public void setExamPaperService(
			IExaminationPaperService<ExaminationPaper> examPaperService) {
		this.examPaperService = examPaperService;
	}
	@Resource(name="employeeService")
	public void setEmployeeService(IEmployeeService<Employee> employeeService) {
		this.employeeService = employeeService;
	}

	@Resource(name="examinationScoreService")
	public void setExamScoreService(
			IExaminationScoreService<ExaminationScore> examScoreService) {
		this.examScoreService = examScoreService;
	}

	@JSON(serialize = false)
	public Float getScore() {
		return score;
	}

	public Integer[] getSelectKeys() {
		return selectKeys;
	}

	public void setQuestion_id(String questionId) {
		question_id = questionId;
	}

	public void setKeys(Integer[] keys) {
		this.keys = keys;
	}

	public Integer[] getKeys() {
		return keys;
	}

	public Pagination<ExaminationQuestion> getPagination() {
		return pagination;
	}

	@Resource(name = "examinationQuestionService")
	public void setQuestionService(
			IExaminationQuestionService<ExaminationQuestion> questionService) {
		this.questionService = questionService;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	@SuppressWarnings("unchecked")
	@JSON(serialize = false)
	public String execute() throws Exception {
		if (sessionMap.get("keyMap") == null) {
			Map<String, Object> keyMap = new HashMap<String, Object>();
			sessionMap.put("keyMap", keyMap);
		}
		System.out.println("exe:" + question_id);
		if (question_id != null) {
			Map<String, Object> keyMap = (Map<String, Object>) sessionMap
					.get("keyMap");
			keyMap.put(question_id, keys);
		}
		pagination = questionService.findExaminationQuestionsByPaperId(
				(String) sessionMap.get("paper_id"), new PageInfo(pageNo, 1));
		String q_id = pagination.getList().get(0).getQuestion_id();
		selectKeys = (Integer[]) ((Map<String, Object>) sessionMap
				.get("keyMap")).get(q_id);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	@JSON(serialize = false)
	public String result() {
		if (sessionMap.get("keyMap") == null) {
			Map<String, Object> keyMap = new HashMap<String, Object>();
			sessionMap.put("keyMap", keyMap);
		}
		System.out.println("get:" + question_id);
		if (question_id != null) {
			Map<String, Object> keyMap = (Map<String, Object>) sessionMap
					.get("keyMap");
			keyMap.put(question_id, keys);
		}
		resultHandler();
		sessionMap.remove("keyMap");
		return "result";
	}

	@SuppressWarnings("unchecked")
	@JSON(serialize = false)
	public void resultHandler() {
		Map<String, Object> keyMap = (Map<String, Object>) sessionMap
				.get("keyMap");
		score = 0f;
		for (Object key : keyMap.keySet()) {
			ExaminationQuestion question = questionService
					.findByQuestionId((String) key);
			Set<ExaminationKey> keyset = question.getKeys();
			List<ExaminationKey> correctKeys = new ArrayList<ExaminationKey>();
			for (ExaminationKey examKey : keyset) {
				if (examKey.getCorrect() == YesNo.是) {
					correctKeys.add(examKey);
				}
			}
			Integer[] temp = (Integer[]) keyMap.get(key);
			if (temp != null && correctKeys != null
					&& correctKeys.size() == temp.length) {
				boolean isRight = false;
				for (ExaminationKey examKey : correctKeys) {
					for (Integer k : temp) {
						isRight = (examKey.getId().intValue() == k.intValue())
								| isRight;
						if (isRight) {
							break;
						}
					}
					if (!isRight) {
						return;
					}
				}
				if (isRight) {
					score += question.getScore();
				}
			}
		}
		//将成绩放入数据库
		ExaminationScore examsScore = new ExaminationScore();
		//Date now = new Date();
		Date startDate = (Date)sessionMap.get("startTime");
		examsScore.setAnswerTime(0);
		examsScore.setDate(startDate);
		Employee employee = employeeService.findByEmployeeId(((OperateEmployee)sessionMap.get("operateEmployee")).getEmp_id());
		examsScore.setEmployee(employee);
		ExaminationPaper examPaper = examPaperService.findByPaperId((String)sessionMap.get("paper_id"));
		examsScore.setPaper(examPaper);
		examsScore.setScore(score);
		examScoreService.save(examsScore);
		//将Session中的部分信息清除
		sessionMap.remove("startTime");
		sessionMap.remove("paper_id");
		sessionMap.remove("keyMap");
		state = true;
	}

	@JSON(serialize = false)
	public String getAll() {
		pagination = questionService.findExaminationQuestions(null,
				new PageInfo(1, 99999));
		return "all";
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
