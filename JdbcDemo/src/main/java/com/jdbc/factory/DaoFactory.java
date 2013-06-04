package com.jdbc.factory;

import java.util.ResourceBundle;

import com.jdbc.exception.BusinessException;

/**
 * 
 * @author Jerval
 * 
 * @date 2011-6-1
 */
public class DaoFactory {

	public static Object get(String daoName) {
		ResourceBundle rb = ResourceBundle.getBundle("DaoConfig");
		Object dao = null;
		try {
			dao = Class.forName(rb.getString(daoName)).newInstance();
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), e);
		}
		return dao;
	}
}
