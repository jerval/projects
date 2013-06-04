package cn.itcast.bbs.domain;

import java.io.Serializable;

/**
 * 操作日志
 * 
 * @author 传智播客.汤阳光 Jul 16, 2008
 */
@SuppressWarnings("unchecked")
public class OperationLog extends SystemLog {
	private Class entityType;// 所操作的实体(资源)类型
	private Serializable entityId;// 所操作的实体的id
	private String type;

	public OperationLog() {
	}

	public Class getEntityType() {
		return entityType;
	}

	public Serializable getEntityId() {
		return entityId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setEntityType(Class entityType) {
		this.entityType = entityType;
	}

	public void setEntityId(Serializable entityId) {
		this.entityId = entityId;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("[OperationLog: ")//
				.append("id=").append(getId())//
				.append(",logTime=").append(getLogTime())//
				.append(",operator=").append(getOperator() == null ? null : getOperator().getLoginName())//
				.append(",operIpAddr=").append(getOperIpAddr())//
				.append(",comment=").append(getComment())//
				.append(",entityType=").append(entityType)//
				.append(",entityId=").append(entityId)//
				.append(",type=").append(type)//
				.append("]")//
				.toString();
	}
}
