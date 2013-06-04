package com.jvwl.train.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.jvwl.train.bean.YesNo;
import com.jvwl.train.model.base.BaseBean;

/**
 * 培训课程明细表
 * 
 * @author wcj
 */
@Entity
public class HrTrainingExecDetail  extends BaseBean{
	/**
	 * 培训课程标号
	 */
	
	private String execsubNO;
	/**
	 * 培训课程名称
	 */

	private String companytrainName;
	/**
	 * 培训师
	 */
	
	private String companytrainManager;

	/**
	 * 结课标志
	 */
	
	private YesNo execFlag;
	/**
	 * 实际开始时间
	 */
	private Date execbeginTime;
	/**
	 * 实际结束时间
	 */
	private Date execendTime;
	/**
	 * 实际培训课时
	 */
	
	private Float execHour;
	/**
	 * 结课小结
	 */
	
	private String courcesummary;

	@Column(unique = true, length = 9)
	public String getExecsubNO() {
		return execsubNO;
	}

	public void setExecsubNO(String execsubNO) {
		this.execsubNO = execsubNO;
	}
	@Column(length = 100)
	public String getCompanytrainName() {
		return companytrainName;
	}

	public void setCompanytrainName(String companytrainName) {
		this.companytrainName = companytrainName;
	}
	@Column(length = 20)
	public String getCompanytrainManager() {
		return companytrainManager;
	}

	public void setCompanytrainManager(String companytrainManager) {
		this.companytrainManager = companytrainManager;
	}

	
	@Enumerated(EnumType.ORDINAL)
	public YesNo getExecFlag() {
		return execFlag;
	}

	public void setExecFlag(YesNo execFlag) {
		this.execFlag = execFlag;
	}

	public Date getExecbeginTime() {
		return execbeginTime;
	}

	public void setExecbeginTime(Date execbeginTime) {
		this.execbeginTime = execbeginTime;
	}

	public Date getExecendTime() {
		return execendTime;
	}

	public void setExecendTime(Date execendTime) {
		this.execendTime = execendTime;
	}
	@Column(precision = 4, scale = 1)
	public Float getExecHour() {
		return execHour;
	}

	public void setExecHour(Float execHour) {
		this.execHour = execHour;
	}
	@Column(length = 1000)
	public String getCourcesummary() {
		return courcesummary;
	}

	public void setCourcesummary(String courcesummary) {
		this.courcesummary = courcesummary;
	}

	@Override
	public String toString() {
		return "HrTrainingExecDetail [companytrainManager="
				+ companytrainManager + ", companytrainName="
				+ companytrainName + ", courcesummary=" + courcesummary
				+ ", execFlag=" + execFlag + ", execHour=" + execHour
				+ ", execbeginTime=" + execbeginTime + ", execendTime="
				+ execendTime + ", execsubNO=" + execsubNO + "]";
	}

}
