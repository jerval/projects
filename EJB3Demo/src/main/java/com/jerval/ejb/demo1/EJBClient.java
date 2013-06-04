package com.jerval.ejb.demo1;

import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;

public class EJBClient {

	public static void main(String[] args) {
		way3();
	}
	public static void way1(){
		Properties properties = new Properties();
		//java.naming.factory.initial为固定写法
		//org.jnp.interfaces.NamingContextFactory 为jboss的链接工厂
		properties.setProperty("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		
//		用于设置命名服务器的链接URL
		properties.setProperty("java.naming.provider.url", "localhost:1099");

		try {
			InitialContext initialContext = new InitialContext(properties);
			HelloWorld helloWord = (HelloWorld) initialContext
					.lookup("HelloWorldBean/remote");
			System.out.println(helloWord.sayHello("java1"));
			System.out.println(helloWord.getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void way2(){
		Properties properties = new Properties();
		InputStream is = EJBClient.class.getClassLoader().getResourceAsStream("ejb_config.properties");
		try {
			properties.load(is);
			InitialContext initialContext = new InitialContext(properties);
			HelloWorld helloWord = (HelloWorld) initialContext
					.lookup("HelloWorldBean/remote");
			System.out.println(helloWord.sayHello("java2"));
			System.out.println(helloWord.getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void way3(){
		try {
			//默认会到类路径下寻找名字为jndi的属性文件
			InitialContext initialContext = new InitialContext();
			HelloWorld helloWord = (HelloWorld) initialContext
					.lookup("HelloWorldBean/remote");
			System.out.println(helloWord.sayHello("java3"));
			System.out.println(helloWord.getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
