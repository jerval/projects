package com.jvwl.forum.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFactory {
	
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("jvwl");
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return factory;
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	public static void closeEntityManager(EntityManager entityManager) {
		if (entityManager != null) {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}
}
