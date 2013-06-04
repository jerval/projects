package com.jvwl.util;

import java.util.Map;

import javax.persistence.Query;

/*
 * Handler QL
 */
public class QLHandler {
	private Object[] keys = null;

	/**
	 * Using blur to find results. eg "a like 'b'" Note: you must invoke the
	 * method setParameter(Query query, Map<Object, Object> map), the space will
	 * be place by '%'
	 * 
	 * @param clazz
	 * @param map
	 * @return String prepared QL
	 */
	@SuppressWarnings("unchecked")
	public String getQL(Class clazz, Map<String, Object> map) {
		StringBuffer hql = new StringBuffer("select o from "
				+ clazz.getSimpleName() + " o ");
		if (map != null && map.size() > 0) {
			keys = map.keySet().toArray();
			hql.append(" where ");
			for (int i = 0; i < keys.length; i++) {
				hql.append("o." + keys[i] + " like :" + keys[i] + "");
				if (i < keys.length - 1) {
					hql.append(" and ");
				}
			}
		}
		return hql.toString();
	}

	/**
	 * Using the strict way to match fields. eg 'a=12' Note: you must invoke the
	 * method setParameter(Query query, Map<Object, Object> map), the space will
	 * be place by '%'
	 * 
	 * @param clazz
	 * @param map
	 * @return String prepared QL
	 */
	@SuppressWarnings("unchecked")
	public String getQLStrict(Class clazz, Map<String, Object> map) {
		StringBuffer hql = new StringBuffer("select o from "
				+ clazz.getSimpleName() + " o ");
		if (map != null && map.size() > 0) {
			keys = map.keySet().toArray();
			hql.append(" where ");
			for (int i = 0; i < keys.length; i++) {
				hql.append("o." + keys[i] + " = :" + keys[i] + "");
				if (i < keys.length - 1) {
					hql.append(" and ");
				}
			}
		}
		return hql.toString();
	}

	/**
	 * the method return a long type values of total elements
	 * for QL like
	 * @param clazz
	 * @param map
	 * @return String prepared QL
	 */
	@SuppressWarnings("unchecked")
	public String getQLCount(Class clazz, Map<String, Object> map) {
		StringBuffer hql = new StringBuffer("select count(o) from "
				+ clazz.getSimpleName() + " o ");
		if (map != null && map.size() > 0) {
			keys = map.keySet().toArray();
			hql.append(" where ");
			for (int i = 0; i < keys.length; i++) {
				hql.append("o." + keys[i] + " like :" + keys[i] + "");
				if (i < keys.length - 1) {
					hql.append(" and ");
				}
			}
		}
		return hql.toString();
	}
	/**
	 * the method return a long type values of total elements
	 * for QL strict
	 * @param clazz
	 * @param map
	 * @return String prepared QL
	 */
	@SuppressWarnings("unchecked")
	public String getQLStrictCount(Class clazz, Map<String, Object> map) {
		StringBuffer hql = new StringBuffer("select count(o) from "
				+ clazz.getSimpleName() + " o ");
		if (map != null && map.size() > 0) {
			keys = map.keySet().toArray();
			hql.append(" where ");
			for (int i = 0; i < keys.length; i++) {
				hql.append("o." + keys[i] + " = :" + keys[i] + "");
				if (i < keys.length - 1) {
					hql.append(" and ");
				}
			}
		}
		return hql.toString();
	}
	/**
	 * set your parameters into QL Note: this method is required if you has
	 * invoked one of methods eg 'getQLStrict(Class clazz, Map<Object, Object>
	 * map)','getQL(Class clazz, Map<Object, Object> map)'
	 * 
	 * @param query
	 * @param map
	 */
	public void setParameter(Query query, Map<String, Object> map) {
		if (map != null && map.size() > 0) {
			for (int i = 0; i < keys.length; i++) {
				Object value = map.get(keys[i]);
				if (value instanceof String) {
					value = ((String) value).replaceAll(" ", "%");
				}
				query.setParameter(keys[i].toString(), value);
			}
		}
	}
	public void setParameterStrict(Query query, Map<String, Object> map) {
		if (map != null && map.size() > 0) {
			for (int i = 0; i < keys.length; i++) {
				Object value = map.get(keys[i]);
				query.setParameter(keys[i].toString(), value);
			}
		}
	}
}
