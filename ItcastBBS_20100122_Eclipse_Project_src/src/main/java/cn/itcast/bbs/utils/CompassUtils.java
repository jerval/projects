package cn.itcast.bbs.utils;

import org.compass.core.Compass;
import org.compass.core.config.CompassConfiguration;
import org.compass.core.config.CompassEnvironment;

public class CompassUtils {

	// 只需要一份实例就可以了
	private static Compass compass;
	private static String applicationRealPath = ".";

	/**
	 * 初始化
	 * 
	 * @param applicationRealPath
	 */
	public static void init(String applicationRealPath) {
		CompassUtils.applicationRealPath = applicationRealPath;

		CompassConfiguration cfg = new CompassConfiguration().configure();
		// FIXME Lucene的connection的相对路径，
		String subConnPath = cfg.getSettings().getSetting(CompassEnvironment.CONNECTION);
		subConnPath = subConnPath.substring("/file://".length() - 1);

		String connection = applicationRealPath + subConnPath;
		cfg.setConnection(connection);

		compass = cfg.buildCompass();
	}

	public static Compass getCompass() {
		return compass;
	}

	public static String getApplicationRealPath() {
		return applicationRealPath;
	}

}
