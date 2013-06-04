package com.jvwl.train.dto;

import com.jvwl.train.bean.YesNo;
import com.jvwl.train.model.base.BaseBean;

/**
 * 培训课程明细表
 * 
 * @author wcj
 */
public class HrTrainingExecDetailDto extends BaseBean {

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

	public String getExecsubNO() {
		return execsubNO;
	}

	public void setExecsubNO(String execsubNO) {
		this.execsubNO = execsubNO;
	}

	public String getCompanytrainName() {
		return companytrainName;
	}

	public void setCompanytrainName(String companytrainName) {
		this.companytrainName = companytrainName;
	}

	public String getCompanytrainManager() {
		return companytrainManager;
	}

	public void setCompanytrainManager(String companytrainManager) {
		this.companytrainManager = companytrainManager;
	}

	public YesNo getExecFlag() {
		return execFlag;
	}

	public void setExecFlag(YesNo execFlag) {
		this.execFlag = execFlag;
	}

	@Override
	public String toString() {
		return "HrTrainingExecDetailDto [companytrainManager="
				+ companytrainManager + ", companytrainName="
				+ companytrainName + ", execFlag=" + execFlag + ", execsubNO="
				+ execsubNO + "]";
	}

	

}
