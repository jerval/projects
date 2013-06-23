package com.jerval.ejb3.mdb;

import java.util.Properties;

import javax.naming.InitialContext;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		//java.naming.factory.initial为固定写法
		//org.jnp.interfaces.NamingContextFactory 为jboss的链接工厂
		properties.setProperty("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
		//用于设置命名服务器的链接URL
		properties.setProperty("java.naming.provider.url", "localhost:1099");

		InitialContext ctx = new InitialContext(properties);  
		MessageSenderService messageSenderService = (MessageSenderService) ctx.lookup("MessageSenderBean/remote"); 
		messageSenderService.sendMessage("World");
        
	}

}
