package cn.itcast.bbs.init;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Ignore;
import org.junit.Test;

public class InitDatabase {

	@Test
	@Ignore
	public void create() {
		Configuration cfg = new Configuration().configure();
		SchemaExport schemaExport = new SchemaExport(cfg);
		schemaExport.create(true, true);
	}

	@Test
	public void update() { // hbm2ddl=update
		new Configuration().configure().buildSessionFactory();
	}
}
