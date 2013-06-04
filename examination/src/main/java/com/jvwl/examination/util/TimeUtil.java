package com.jvwl.examination.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		return sdf.format(new Date());
	}

	public static Date parseDateTime(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(d);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getDateTime(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		}
		return null;
	}

	public static String getDate(Date date) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		}
		return null;
	}

	public static Date parseDate(String d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(d);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
