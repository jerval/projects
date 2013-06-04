package com.mybatis.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.app.model.Student;
import com.mybatis.app.util.Page;

public interface StudentMapper {

	@Insert("insert into student(id,name,birthday) values(#{id},#{name},#{birthday})")
	public abstract void add(Student student);

	@Update("update student set name=#{name},birthday=#{birthday} WHERE id = #{id}")
	public abstract void update(Student student);

	@Delete("delete FROM student WHERE id = #{id}")
	public abstract void delete(Integer id);

	@Select("SELECT * FROM student WHERE id = #{id}")
	public abstract Student findById(Integer id);

	@Select("SELECT * FROM student limit #{startNo},#{pageSize}")
	public abstract List<Student> findByPage(Page page);
	
	public abstract List<String> findNamesByPage(Page page);
	
	public abstract List<Map<String, Object>> findCommonByPage(Page page);
}
