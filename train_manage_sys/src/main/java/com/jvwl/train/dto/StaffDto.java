package com.jvwl.train.dto;

import java.util.Date;

import com.jvwl.train.bean.Gender;
import com.jvwl.train.bean.YesNo;

/**
 * 员工基本信息
 * 
 * @author liuxin
 */

public class StaffDto{
	/**
	 * 用户编号
	 */
	
	private String userId;
	/**
	 * 应聘者编号
	 */
	
	private ToEmployInfoDto toEmployee;

	
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
	private Date birthday2;
	/**
	 * 入职日期
	 */
	
	private Date comeDate;
	private Date comeDate2;
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
	private Date graduationDate2;
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
	private Date leaveDate2;
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
	private Date insertDate2;
	/**
	 * 更新着
	 */
	
	private String updateUser;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	private Date updateDate2;
	/**
	 * 删除标志
	 */
	private YesNo deleteFlag;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ToEmployInfoDto getToEmployee() {
		return toEmployee;
	}
	public void setToEmployee(ToEmployInfoDto toEmployee) {
		this.toEmployee = toEmployee;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserChinaname() {
		return userChinaname;
	}
	public void setUserChinaname(String userChinaname) {
		this.userChinaname = userChinaname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAlamName() {
		return alamName;
	}
	public void setAlamName(String alamName) {
		this.alamName = alamName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Gender getSex() {
		return sex;
	}
	public void setSex(Gender sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getBirthday2() {
		return birthday2;
	}
	public void setBirthday2(Date birthday2) {
		this.birthday2 = birthday2;
	}
	public Date getComeDate() {
		return comeDate;
	}
	public void setComeDate(Date comeDate) {
		this.comeDate = comeDate;
	}
	public Date getComeDate2() {
		return comeDate2;
	}
	public void setComeDate2(Date comeDate2) {
		this.comeDate2 = comeDate2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHomeAdress() {
		return homeAdress;
	}
	public void setHomeAdress(String homeAdress) {
		this.homeAdress = homeAdress;
	}
	public String getHomepostCode() {
		return homepostCode;
	}
	public void setHomepostCode(String homepostCode) {
		this.homepostCode = homepostCode;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Date getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}
	public Date getGraduationDate2() {
		return graduationDate2;
	}
	public void setGraduationDate2(Date graduationDate2) {
		this.graduationDate2 = graduationDate2;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getHouseholdAdress() {
		return householdAdress;
	}
	public void setHouseholdAdress(String householdAdress) {
		this.householdAdress = householdAdress;
	}
	public YesNo getMarrystatus() {
		return marrystatus;
	}
	public void setMarrystatus(YesNo marrystatus) {
		this.marrystatus = marrystatus;
	}
	public String getTechnicalClass() {
		return technicalClass;
	}
	public void setTechnicalClass(String technicalClass) {
		this.technicalClass = technicalClass;
	}
	public String getPolitics() {
		return politics;
	}
	public void setPolitics(String politics) {
		this.politics = politics;
	}
	public String getAccumfundCounter() {
		return accumfundCounter;
	}
	public void setAccumfundCounter(String accumfundCounter) {
		this.accumfundCounter = accumfundCounter;
	}
	public String getPensionCounter() {
		return pensionCounter;
	}
	public void setPensionCounter(String pensionCounter) {
		this.pensionCounter = pensionCounter;
	}
	public String getMedicareCounter() {
		return medicareCounter;
	}
	public void setMedicareCounter(String medicareCounter) {
		this.medicareCounter = medicareCounter;
	}
	public String getIdentitycardID() {
		return identitycardID;
	}
	public void setIdentitycardID(String identitycardID) {
		this.identitycardID = identitycardID;
	}
	public String getStafffileID() {
		return stafffileID;
	}
	public void setStafffileID(String stafffileID) {
		this.stafffileID = stafffileID;
	}
	public String getStafffilePath() {
		return stafffilePath;
	}
	public void setStafffilePath(String stafffilePath) {
		this.stafffilePath = stafffilePath;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public Date getLeaveDate2() {
		return leaveDate2;
	}
	public void setLeaveDate2(Date leaveDate2) {
		this.leaveDate2 = leaveDate2;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
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
	public Date getInsertDate2() {
		return insertDate2;
	}
	public void setInsertDate2(Date insertDate2) {
		this.insertDate2 = insertDate2;
	}
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
	public Date getUpdateDate2() {
		return updateDate2;
	}
	public void setUpdateDate2(Date updateDate2) {
		this.updateDate2 = updateDate2;
	}
	public YesNo getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(YesNo deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	@Override
	public String toString() {
		return "StaffDto [accumfundCounter=" + accumfundCounter + ", address="
				+ address + ", alamName=" + alamName + ", birthday=" + birthday
				+ ", birthday2=" + birthday2 + ", comeDate=" + comeDate
				+ ", comeDate2=" + comeDate2 + ", degree=" + degree
				+ ", deleteFlag=" + deleteFlag + ", education=" + education
				+ ", email=" + email + ", email2=" + email2
				+ ", graduationDate=" + graduationDate + ", graduationDate2="
				+ graduationDate2 + ", homeAdress=" + homeAdress
				+ ", homePhone=" + homePhone + ", homepostCode=" + homepostCode
				+ ", householdAdress=" + householdAdress + ", identitycardID="
				+ identitycardID + ", insertDate=" + insertDate
				+ ", insertDate2=" + insertDate2 + ", insertUser=" + insertUser
				+ ", leaveDate=" + leaveDate + ", leaveDate2=" + leaveDate2
				+ ", leaveReason=" + leaveReason + ", major=" + major
				+ ", marrystatus=" + marrystatus + ", medicareCounter="
				+ medicareCounter + ", mobile=" + mobile + ", nativePlace="
				+ nativePlace + ", password=" + password + ", pensionCounter="
				+ pensionCounter + ", phone=" + phone + ", politics="
				+ politics + ", postCode=" + postCode + ", school=" + school
				+ ", sex=" + sex + ", stafffileID=" + stafffileID
				+ ", stafffilePath=" + stafffilePath + ", technicalClass="
				+ technicalClass + ", toEmployee=" + toEmployee
				+ ", updateDate=" + updateDate + ", updateDate2=" + updateDate2
				+ ", updateUser=" + updateUser + ", userChinaname="
				+ userChinaname + ", userId=" + userId + ", userName="
				+ userName + ", userNumber=" + userNumber + ", userType="
				+ userType + "]";
	}
	
}
