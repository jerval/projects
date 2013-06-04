package com.jvwl.test.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.jvwl.test.exception.BusinessException;

public class DateConvertor extends StrutsTypeConverter {
	@SuppressWarnings("unchecked")
	@Override
	public Object convertFromString(Map map, String[] values, Class toClass) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date =null;
		try {
			date = sdf.parse("");
		} catch (ParseException e) {
			throw BusinessException.systemException("日期解析错误！");
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
