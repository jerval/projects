package com.jvwl.test;

public class sta {
	private static String a="kkk";
	static {
		System.out.println("static");
		System.out.println(a);
	}

	public sta() {
		System.out.println("constructor");
	}
	public static void ttt() {
		System.out.println("static method");	
	}
}
