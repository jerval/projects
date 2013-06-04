package com.jvwl.test.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter1 extends StrutsTypeConverter {

	@SuppressWarnings("unchecked")
	@Override
	public Object convertFromString(Map map, String[] values, Class toClass) {
		for(String value:values){
			System.out.println(value);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String convertToString(Map map, Object object) {
		return null;
	}

}
