package cn.itcast.bbs.domain;

/**
 * 权限
 * 
 * @author tyg
 */
public class SystemPrivilege {
	private String id;
	private String name; // 权限名称

	private String resource; // 所操作的资源
	private String action;// 对资源所做的操作

	public SystemPrivilege() {
	}

	public SystemPrivilege(String resource, String action) {
		this.resource = resource;
		this.action = action;
	}

	public SystemPrivilege(String name, String resource, String action) {
		this.name = name;
		this.resource = resource;
		this.action = action;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("[SystemPrivilege: ")//
				.append("id=").append(id)//
				.append(",name=").append(name)//
				.append(",resource=").append(resource)//
				.append(",action=").append(action)//
				.append("]")//
				.toString();
	}

}
