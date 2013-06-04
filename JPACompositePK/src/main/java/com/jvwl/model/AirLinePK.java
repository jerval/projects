package com.jvwl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/*定义联合主键类要求：
 * 1.要有无参构造方法
 * 2.要实现序列化接口
 * 3.重写hashCode方法和equals方法
 */
@Embeddable
// 标识它不是一个实体，而是嵌入别的实体中的一个属性。
public class AirLinePK implements Serializable {

	private static final long serialVersionUID = 5940144469818589822L;
	private String startCity;
	private String endCity;

	public AirLinePK() {
	}

	public AirLinePK(String startCity, String endCity) {
		this.startCity = startCity;
		this.endCity = endCity;
	}

	@Column(length = 3)
	public String getStartCity() {
		return startCity;
	}

	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}

	@Column(length = 3)
	public String getEndCity() {
		return endCity;
	}

	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endCity == null) ? 0 : endCity.hashCode());
		result = prime * result
				+ ((startCity == null) ? 0 : startCity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirLinePK other = (AirLinePK) obj;
		if (endCity == null) {
			if (other.endCity != null)
				return false;
		} else if (!endCity.equals(other.endCity))
			return false;
		if (startCity == null) {
			if (other.startCity != null)
				return false;
		} else if (!startCity.equals(other.startCity))
			return false;
		return true;
	}

}
