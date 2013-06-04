package com.jvwl.train.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jvwl.train.bean.Gender;
import com.jvwl.train.bean.YesNo;
import com.jvwl.train.model.base.BaseBean;

/**
 * 员工基本信息
 * 
 * @author wangchan
 */
@Entity
public class Staff  extends BaseBean{
	/**
	 * 用户编号
	 */
	
	private String userId;
	/**
	 * 应聘者编号
	 */
	
	private ToEmployInfo toEmployee;

	
	private String userNumber;
	/**
	 * 用户中文名
	 */
	
	private String userChinaname;
	/**
	 * 用户日文名
	 */
	
	private String userName;
	/**
	 * 姓名全拼音
	 */
	
	private String alamName;
	/**
	 * 用户密码
	 */
	
	private String password;
	/**
	 * 性别
	 */
	
	private Gender sex;
	/**
	 * 出生年月日
	 */
	
	private Date birthday;
	/**
	 * 入职日期
	 */
	
	private Date comeDate;
	/**
	 * 公司邮箱
	 */
	
	private String email;
	/**
	 * 私用邮箱
	 */
	
	private String email2;
	/**
	 * 移动电话
	 */
	
	private String mobile;
	/**
	 * 居住地址
	 */
	
	private String address;
	/**
	 * 居住地邮政编码
	 */
	
	private String postCode;
	/**
	 * 居住地宅电话
	 */
	
	private String phone;
	/**
	 * 家庭地址
	 */
	
	private String homeAdress;
	/**
	 * 家庭邮政编码
	 */
	
	private String homepostCode;
	/**
	 * 家庭宅电
	 */
	
	private String homePhone;
	/**
	 * 毕业学校
	 */
	
	private String school;
	/**
	 * 所学专业
	 */
	
	private String major;
	/**
	 * 毕业时间
	 */
	
	private Date graduationDate;
	/**
	 * 学位
	 */
	
	private String degree;
	/**
	 * 学历
	 */
	
	private String education;
	/**
	 * 籍贯
	 */
	
	private String nativePlace;
	/**
	 * 户口所在地
	 */
	
	private String householdAdress;
	/**
	 * 婚姻状况
	 */
	
	private YesNo marrystatus;
	/**
	 * 技术等级
	 */
	
	private String technicalClass;
	/**
	 * 政治面貌
	 */
	
	private String politics;
	/**
	 * 公积金账号
	 */
	
	private String accumfundCounter;
	/**
	 * 养老账号
	 */
	
	private String pensionCounter;
	/**
	 * 医保账号
	 */
	
	private String medicareCounter;
	/**
	 * 身份证号码
	 */
	
	private String identitycardID;
	/**
	 * 员工档案编号
	 */
	
	private String stafffileID;
	/**
	 * 员工方案存放地址
	 */
	
	private String stafffilePath;
	/**
	 * 提出离职日期
	 */
	
	private Date leaveDate;
	/**
	 * 离职原因
	 */
	
	private String leaveReason;
	/**
	 * 用户类别
	 */
	
	private String userType;
	/**
	 * 登陆者
	 */
	
	private String insertUser;
	/**
	 * 登陆日期
	 */
	private Date insertDate;
	/**
	 * 更新着
	 */
	
	private String updateUser;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	/**
	 * 删除标志
	 */
	private YesNo deleteFlag;

	@Column(unique = true, length = 20)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@ManyToOne
	@JoinColumn(name = "toEmployee_id")
	public ToEmployInfo getToEmployee() {
		return toEmployee;
	}

	public void setToEmployee(ToEmployInfo toEmployee) {
		this.toEmployee = toEmployee;
	}

	@Column(length = 20)
	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	@Column(length = 20)
	public String getUserChinaname() {
		return userChinaname;
	}

	public void setUserChinaname(String userChinaname) {
		this.userChinaname = userChinaname;
	}

	@Column(length = 20)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(length = 20)
	public String getAlamName() {
		return alamName;
	}

	public void setAlamName(String alamName) {
		this.alamName = alamName;
	}

	@Column(length = 32)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.ORDINAL)
	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Temporal(TemporalType.DATE)
	public Date getComeDate() {
		return comeDate;
	}

	public void setComeDate(Date comeDate) {
		this.comeDate = comeDate;
	}

	@Column(length = 32)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 32)
	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	@Column(length = 20)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(length = 100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(length = 6)
	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@Column(length = 12)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 100)
	public String getHomeAdress() {
		return homeAdress;
	}

	public void setHomeAdress(String homeAdress) {
		this.homeAdress = homeAdress;
	}

	@Column(length = 6)
	public String getHomepostCode() {
		return homepostCode;
	}

	public void setHomepostCode(String homepostCode) {
		this.homepostCode = homepostCode;
	}

	@Column(length = 12)
	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@Column(length = 100)
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	@Column(length = 40)
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Temporal(TemporalType.DATE)
	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	@Column(length = 20)
	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Column(length = 20)
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Column(length = 40)
	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	@Column(length = 100)
	public String getHouseholdAdress() {
		return householdAdress;
	}

	public void setHouseholdAdress(String householdAdress) {
		this.householdAdress = householdAdress;
	}

	@Enumerated(EnumType.ORDINAL)
	public YesNo getMarrystatus() {
		return marrystatus;
	}

	public void setMarrystatus(YesNo marrystatus) {
		this.marrystatus = marrystatus;
	}

	@Column(length = 10)
	public String getTechnicalClass() {
		return technicalClass;
	}

	public void setTechnicalClass(String technicalClass) {
		this.technicalClass = technicalClass;
	}

	@Column(length = 100)
	public String getPolitics() {
		return politics;
	}

	public void setPolitics(String politics) {
		this.politics = politics;
	}

	@Column(length = 100)
	public String getAccumfundCounter() {
		return accumfundCounter;
	}

	public void setAccumfundCounter(String accumfundCounter) {
		this.accumfundCounter = accumfundCounter;
	}

	@Column(length = 100)
	public String getPensionCounter() {
		return pensionCounter;
	}

	public void setPensionCounter(String pensionCounter) {
		this.pensionCounter = pensionCounter;
	}

	@Column(length = 20)
	public String getMedicareCounter() {
		return medicareCounter;
	}

	public void setMedicareCounter(String medicareCounter) {
		this.medicareCounter = medicareCounter;
	}

	@Column(length = 18)
	public String getIdentitycardID() {
		return identitycardID;
	}

	public void setIdentitycardID(String identitycardID) {
		this.identitycardID = identitycardID;
	}

	@Column(length = 20)
	public String getStafffileID() {
		return stafffileID;
	}

	public void setStafffileID(String stafffileID) {
		this.stafffileID = stafffileID;
	}

	@Column(length = 40)
	public String getStafffilePath() {
		return stafffilePath;
	}

	public void setStafffilePath(String stafffilePath) {
		this.stafffilePath = stafffilePath;
	}

	@Temporal(TemporalType.DATE)
	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	@Column(length = 30)
	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	@Column(length = 30)
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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
