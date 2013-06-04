package cn.itcast.bbs.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 分类(顶级版面)
 * 
 * @author 传智博客.汤阳光 Jun 19, 2008
 */
public class Category {
	private String id;
	private String name; // 名称
	private int order;// 显示顺序
	private Set<Forum> forums = new HashSet<Forum>(0); // 子版面，配置时使用order-by属性指定按forum.order排序

	public Category() {
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

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Set<Forum> getForums() {
		return forums;
	}

	public void setForums(Set<Forum> forums) {
		this.forums = forums;
	}

}
