package com.jvwl.test;

import org.junit.Test;

public class tt {
	@Test
	public void test(){
		try {
			Class.forName("com.jvwl.test.sta").newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		new sta();
	}
}
