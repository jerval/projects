package com.jerval.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
// @Table(name="teacher")//default
public class Teacher implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5215695246501014006L;
	private Integer id;
	private String name;

	public Teacher() {
	}

	public Teacher(String name) {
		this.name = name;
	}

	@Id//JPA通过ID注解来判断所有注解是标在属性上还是get方法上，所以注解不能两处写
	@GeneratedValue
	// (strategy=GenerationType.AUTO)//default
	// @Column(name="id")//default
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 10, nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Teacher other = (Teacher) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
	}

}
