package com.jvwl;

import javax.persistence.EntityManager;

import com.jvwl.model.Department;
import com.jvwl.util.EMFactory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager entityManager = EMFactory.getEntityManager();
		entityManager.getTransaction().begin();
		Department department = new Department();
		department.setDepart_id("10");
		department.setDepart_name("je");
		department.setDepart_info("info");
		entityManager.persist(department);

		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
