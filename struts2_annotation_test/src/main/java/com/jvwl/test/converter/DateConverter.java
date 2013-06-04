package com.jvwl.test.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {
	@SuppressWarnings("unchecked")
	@Override
	public Object convertFromString(Map map, String[] values, Class toClass) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date =null;
		try {System.out.println("values :"+values[0]);
			date = sdf.parse(values[0]);
		} catch (ParseException e) {
			throw new RuntimeException("日期解析错误！");
		}
		return date;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String convertToString(Map map, Object object) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(object);
	}
}
