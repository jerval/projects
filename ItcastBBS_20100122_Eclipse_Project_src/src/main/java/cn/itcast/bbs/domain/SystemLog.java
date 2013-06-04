package cn.itcast.bbs.domain;

import java.util.Date;

import cn.itcast.bbs.domain.User;

/**
 * 系统日志
 * 
 * @author 传智播客.汤阳光 Apr 25, 2009
 * 
 */
public abstract class SystemLog {
	private String id;
	private Date logTime;// 记录时间
	private String comment; // 备注
	private User operator;// 操作者
	private String operIpAddr;// 操作者所用的IP地址

	public String getId() {
		return id;
	}

	public Date getLogTime() {
		return logTime;
	}

	public User getOperator() {
		return operator;
	}

	public String getOperIpAddr() {
		return operIpAddr;
	}

	public String getComment() {
		return comment;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	public void setOperIpAddr(String operIpAddr) {
		this.operIpAddr = operIpAddr;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("[SystemLog: ")//
				.append("id=").append(id)//
				.append(",logTime=").append(logTime)//
				.append(",operator=").append(operator == null ? null : operator.getLoginName())//
				.append(",operIpAddr=").append(operIpAddr)//
				.append(",comment=").append(comment)//
				.append("]")//
				.toString();
	}
}
