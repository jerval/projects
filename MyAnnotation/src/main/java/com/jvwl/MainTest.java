package com.jvwl;

public class MainTest {

	public static void main(String[] args) {
		TestBean testBean = new TestBean("abc");
		System.out.println(testBean);
		ParseAnnotation pa =new ParseAnnotation();
		pa.parse(testBean, "toString");
	}

}
