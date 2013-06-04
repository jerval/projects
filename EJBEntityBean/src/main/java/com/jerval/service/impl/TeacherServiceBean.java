package com.jerval.service.impl;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jerval.bean.Teacher;
import com.jerval.service.TeacherService;

@Stateless
@Remote(TeacherService.class)
public class TeacherServiceBean implements TeacherService {

	@PersistenceContext
	// (unitName = "jerval")//if only one,you don't need to
	private EntityManager em;

	@Override
	public void save(Teacher teacher) {
		em.persist(teacher);
	}

	@Override
	public void update(Teacher teacher) {
		em.merge(teacher);
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.getReference(Teacher.class, id));
	}

	@Override
	public Teacher findTeacher(Integer id) {
		return em.find(Teacher.class, id);
	}

	@Override
	public List<Teacher> findTeachers(Integer pageNo, Integer pageSize) {
		@SuppressWarnings("unchecked")
		List<Teacher> teachers = em.createQuery("select t from Teacher t")
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).getResultList();
		return teachers;
	}
}
