package cn.itcast.bbs.dd;

import java.io.Serializable;

/**
 * 数据项。表示数据字典中的一条数据。<br>
 * 一个DataItem代表一条数据信息，DateItem中保存的是数据的元数据，。<br>
 * 不使用 {@link Serializable} 类型的属性来存储 {@link String} 或 {@link Integer} 等类型值的好处是：<br>
 * 可以支持非 {@link Serializable} 且非 HibernatePO 的类型。
 * 
 * @author tyg
 */
@SuppressWarnings("unchecked")
public class DataItem {
	private String id;
	private String name;
	private String stringValue;

	private Class valueType;
	private boolean hibernatePO;

	public DataItem() {
	}

	public DataItem(String name, String stringValue, Class valueType, boolean isHibernatePO) {
		this.valueType = valueType;
		this.hibernatePO = isHibernatePO;
		this.name = name;
		this.stringValue = stringValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Class getValueType() {
		return valueType;
	}

	public void setValueType(Class valueType) {
		this.valueType = valueType;
	}

	public boolean isHibernatePO() {
		return hibernatePO;
	}

	public void setHibernatePO(boolean hibernatePO) {
		this.hibernatePO = hibernatePO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

}
