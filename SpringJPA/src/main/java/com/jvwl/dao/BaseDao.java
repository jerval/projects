package com.jvwl.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDao {
	protected EntityManager em;

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
