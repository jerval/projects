package cn.itcast.bbs.domain;


/**
 * 系统运行时出现的异常记录
 * 
 * @author 传智播客.汤阳光 Dec 15, 2008
 */
public class ExceptionLog extends SystemLog {

	private String className;// 异常的类的类名
	private String summary;// 异常摘要信息(Exception.getMessage)
	private String detailMessage;// 详细信息(Exception.printStackTrace)

	public ExceptionLog() {}

	public String getClassName() {
		return className;
	}

	public String getSummary() {
		return summary;
	}

	public String getDetailMessage() {
		return detailMessage;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("[ExceptionLog: ")//
				.append("id=").append(getId())//
				.append(",logTime=").append(getLogTime())//
				.append(",operator=").append(getOperator() == null ? null : getOperator().getLoginName())//
				.append(",operIpAddr=").append(getOperIpAddr())//
				.append(",comment=").append(getComment())//
				.append(",className=").append(className)//
				.append(",summary=").append(summary)//
				.append(",detailMessage=").append(detailMessage)//
				.append("]")//
				.toString();
	}

}
