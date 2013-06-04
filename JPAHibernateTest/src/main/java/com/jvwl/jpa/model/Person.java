package com.jvwl.jpa.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity  @Table(name = "t_person")
public class Person {
	//private Integer id;
	private String id;
	private String name;
	private PersonGender personGender = PersonGender.MAN;
	private Date birthday;
	private String info ;
	private Byte[] file;
	private String imagePath;
	private Integer version;
	
	@Version  
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Transient  //不让其在数据库中生成对应的列
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Lob @Basic(fetch=FetchType.LAZY)//设置为懒加载
	public Byte[] getFile() {
		return file;
	}

	public void setFile(Byte[] file) {
		this.file = file;
	}

	@Lob //用于来保存大的文本信息或文件字节
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Temporal(TemporalType.DATE) //时间映射
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Enumerated(EnumType.STRING) //枚举映射
	@Column(nullable=false,length=6)
	public PersonGender getPersonGender() {
		return personGender;
	}

	public void setPersonGender(PersonGender personGender) {
		this.personGender = personGender;
	}

	@Column(length = 10, nullable = false, name = "c_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Id @GeneratedValue//主键生成策略，与@GeneratedValue(strategy=GenerationType.AUTO)相同
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
	
	@Id @Column(length=10)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
