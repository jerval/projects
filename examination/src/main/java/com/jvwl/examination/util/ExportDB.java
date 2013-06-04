package com.jvwl.examination.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class ExportDB {
//此类用于导出Hibernate表
	public static void main(String[] args) {
		
		//读取hibernate.cfg.xml文件
		Configuration cfg = new AnnotationConfiguration().configure();
		
		SchemaExport export = new SchemaExport(cfg);
		
		export.create(true, true);
	}
}
