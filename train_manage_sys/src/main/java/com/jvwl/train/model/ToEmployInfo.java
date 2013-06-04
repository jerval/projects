package com.jvwl.train.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jvwl.train.bean.BodyResult;
import com.jvwl.train.bean.EmployState;
import com.jvwl.train.bean.Gender;
import com.jvwl.train.bean.InterviewResult;
import com.jvwl.train.bean.SourceFrom;
import com.jvwl.train.bean.WorkExperience;
import com.jvwl.train.bean.YesNo;
import com.jvwl.train.model.base.BaseBean;

/**
 * 应聘人员信息表
 * 
 * @author liuxin
 * 
 */
@Entity
public class ToEmployInfo extends BaseBean {
	/**
	 * 资料来源
	 */
	
	private SourceFrom fromType;

	/**
	 * 应聘者编号
	 */
	
	private String toEmployee;

	/**
	 * 应聘者姓名
	 */
	
	private String userChinaName;

	/**
	 * 应聘日期
	 */
	
	private Date comeDate;

	/**
	 * 应聘岗位
	 */
	
	private Job job;

	/**
	 * 推荐者
	 */
	
	private String recommender;

	/**
	 * 联系人
	 */
	
	private String connector;

	/**
	 * 身份证号码
	 */
	
	private String identityCardId;

	/**
	 * 性别
	 */
	
	private Gender sex;

	/**
	 * 用户信箱
	 */
	
	private String email;

	/**
	 * 联系电话
	 */
	
	private String mobile;

	/**
	 * 出生年月日
	 */
	
	private Date birthday;

	/**
	 * 毕业院校
	 */
	
	private String schoolName;

	/**
	 * 所学专业
	 */
	
	private String major;

	/**
	 * 已工作年限
	 */
	
	private WorkExperience workYears;

	/**
	 * 前工作单位
	 */
	
	private String preWorkComp;

	/**
	 * 主要项目经验
	 */
	
	private String majorPjExp;

	/**
	 * 得意技术
	 */
	
	private String proTechnology;

	/**
	 * 目前年薪
	 */
	private Integer salary;

	/**
	 * 期待年薪
	 */
	private Integer hopeSalary;

	/**
	 * 笔试日期
	 */
	
	private Date examinationDate;

	/**
	 * 笔试总成绩
	 */
	
	private Float examinationValue;

	/**
	 * 笔试第一题成绩
	 */
	
	private String examinationValue1;

	/**
	 * 笔试第二题成绩
	 */
	
	private String examinationValue2;

	/**
	 * 笔试第三题成绩
	 */
	
	private String examinationValue3;

	/**
	 * 笔试第四题成绩
	 */
	
	private String examinationValue4;

	/**
	 * 性格特征
	 */
	
	private String characteristic;

	/**
	 * 面试结果
	 */
	
	private InterviewResult interViewResult;

	/**
	 * 是否有附件
	 */
	
	private YesNo haveFiles;

	/**
	 * 应聘人员状态
	 */
	
	private EmployState type;

	/**
	 * 业务方向
	 */
	
	private String businessNotes;

	/**
	 * 简短说明
	 */
	
	private String shortNotes;

	/**
	 * 体检情况
	 */
	
	private BodyResult bodyResult;

	/**
	 * 登陆者
	 */
	
	private String insertUser;

	/**
	 * 登陆日期
	 */
	private Date insertDate;

	/**
	 * 更新者
	 */
	
	private String updateUser;

	/**
	 * 更新日期
	 */
	private Date updateDate;

	/**
	 * 削除flag
	 */
	
	private YesNo deleteFlag;

	@Enumerated(EnumType.ORDINAL)
	public SourceFrom getFromType() {
		return fromType;
	}

	public void setFromType(SourceFrom fromType) {
		this.fromType = fromType;
	}
	@Column(length = 20,  unique = true)
	public String getToEmployee() {
		return toEmployee;
	}

	public void setToEmployee(String toEmployee) {
		this.toEmployee = toEmployee;
	}
	@Column(length = 20)
	public String getUserChinaName() {
		return userChinaName;
	}

	public void setUserChinaName(String userChinaName) {
		this.userChinaName = userChinaName;
	}
	@Temporal(TemporalType.DATE)
	public Date getComeDate() {
		return comeDate;
	}

	public void setComeDate(Date comeDate) {
		this.comeDate = comeDate;
	}
	@ManyToOne
	@JoinColumn(name = "job_id")
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	@Column(length = 20)
	public String getRecommender() {
		return recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}
	@Column(length = 20)
	public String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}
	@Column(length = 18)
	public String getIdentityCardId() {
		return identityCardId;
	}

	public void setIdentityCardId(String identityCardId) {
		this.identityCardId = identityCardId;
	}
	@Enumerated(EnumType.ORDINAL)
	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}
	@Column(length = 32)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length = 11)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Column(length = 40, nullable = true)
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	@Column(length = 40)
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	@Enumerated(EnumType.ORDINAL)
	public WorkExperience getWorkYears() {
		return workYears;
	}

	public void setWorkYears(WorkExperience workYears) {
		this.workYears = workYears;
	}
	@Column(length = 60)
	public String getPreWorkComp() {
		return preWorkComp;
	}

	public void setPreWorkComp(String preWorkComp) {
		this.preWorkComp = preWorkComp;
	}
	@Lob
	@Basic(fetch = FetchType.LAZY)
	public String getMajorPjExp() {
		return majorPjExp;
	}

	public void setMajorPjExp(String majorPjExp) {
		this.majorPjExp = majorPjExp;
	}
	@Lob
	@Basic(fetch = FetchType.LAZY)
	public String getProTechnology() {
		return proTechnology;
	}

	public void setProTechnology(String proTechnology) {
		this.proTechnology = proTechnology;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getHopeSalary() {
		return hopeSalary;
	}

	public void setHopeSalary(Integer hopeSalary) {
		this.hopeSalary = hopeSalary;
	}
	@Temporal(TemporalType.DATE)
	public Date getExaminationDate() {
		return examinationDate;
	}

	public void setExaminationDate(Date examinationDate) {
		this.examinationDate = examinationDate;
	}
	@Column(precision = 4, scale = 1)
	public Float getExaminationValue() {
		return examinationValue;
	}

	public void setExaminationValue(Float examinationValue) {
		this.examinationValue = examinationValue;
	}
	@Column(precision = 4, scale = 1)
	public String getExaminationValue1() {
		return examinationValue1;
	}

	public void setExaminationValue1(String examinationValue1) {
		this.examinationValue1 = examinationValue1;
	}
	@Column(precision = 4, scale = 1)
	public String getExaminationValue2() {
		return examinationValue2;
	}

	public void setExaminationValue2(String examinationValue2) {
		this.examinationValue2 = examinationValue2;
	}
	@Column(precision = 4, scale = 1)
	public String getExaminationValue3() {
		return examinationValue3;
	}

	public void setExaminationValue3(String examinationValue3) {
		this.examinationValue3 = examinationValue3;
	}
	@Column(precision = 4, scale = 1)
	public String getExaminationValue4() {
		return examinationValue4;
	}

	public void setExaminationValue4(String examinationValue4) {
		this.examinationValue4 = examinationValue4;
	}
	@Column(length = 20)
	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}
	@Enumerated(EnumType.ORDINAL)
	public InterviewResult getInterViewResult() {
		return interViewResult;
	}

	public void setInterViewResult(InterviewResult interViewResult) {
		this.interViewResult = interViewResult;
	}
	@Enumerated(EnumType.ORDINAL)
	public YesNo getHaveFiles() {
		return haveFiles;
	}

	public void setHaveFiles(YesNo haveFiles) {
		this.haveFiles = haveFiles;
	}
	@Enumerated(EnumType.ORDINAL)
	public EmployState getType() {
		return type;
	}

	public void setType(EmployState type) {
		this.type = type;
	}
	@Column(length = 20)
	public String getBusinessNotes() {
		return businessNotes;
	}

	public void setBusinessNotes(String businessNotes) {
		this.businessNotes = businessNotes;
	}
	@Column(length = 200)
	public String getShortNotes() {
		return shortNotes;
	}

	public void setShortNotes(String shortNotes) {
		this.shortNotes = shortNotes;
	}
	@Enumerated(EnumType.ORDINAL)
	public BodyResult getBodyResult() {
		return bodyResult;
	}

	public void setBodyResult(BodyResult bodyResult) {
		this.bodyResult = bodyResult;
	}
	@Column(length = 20)
	public String getInsertUser() {
		return insertUser;
	}

	public void setInsertUser(String insertUser) {
		this.insertUser = insertUser;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	@Column(length = 20)
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	@Enumerated(EnumType.ORDINAL)
	public YesNo getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(YesNo deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
