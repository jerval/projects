package com.jerval.app;

import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class QueueSender {

	public static void main(String[] args) {
		try {
			InitialContext ctx = new InitialContext();
			QueueConnectionFactory factory = (QueueConnectionFactory) ctx
					.lookup("QueueConnectionFactory");
			QueueConnection conn = factory.createQueueConnection();
			QueueSession session = conn.createQueueSession(false,
					QueueSession.AUTO_ACKNOWLEDGE);
			Destination destination = (Destination) ctx
					.lookup("queue/jervalQueue");
			MessageProducer producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage("你好，蹇伟。");
			producer.send(message);
			session.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
