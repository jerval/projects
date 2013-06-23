package com.jerval.ejb3.mdb;

import java.util.Properties;

import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.naming.InitialContext;

public class MainTest {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		// java.naming.factory.initial为固定写法
		// org.jnp.interfaces.NamingContextFactory 为jboss的链接工厂
		properties.setProperty("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		// 用于设置命名服务器的链接URL
		properties.setProperty("java.naming.provider.url", "localhost:1099");

		InitialContext ctx = new InitialContext(properties);
		QueueConnectionFactory factory = (QueueConnectionFactory) ctx
				.lookup("ConnectionFactory");
		QueueConnection connection = factory.createQueueConnection();
		QueueSession session = connection.createQueueSession(false,
				QueueSession.AUTO_ACKNOWLEDGE);
		Destination destination = (Queue) ctx.lookup("queue/rds/generateQueue");
		MessageProducer messageProducer = session.createProducer(destination);
		ObjectMessage objectMessage = session.createObjectMessage();
		objectMessage.setObject(new User(888, "jerval"));
		messageProducer.send(objectMessage);
		session.close();
		connection.close();
	}

}
