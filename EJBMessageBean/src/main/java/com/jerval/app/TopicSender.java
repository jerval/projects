package com.jerval.app;

import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.InitialContext;

public class TopicSender {

	public static void main(String[] args) {
		try {
			InitialContext ctx = new InitialContext();
			TopicConnectionFactory factory = (TopicConnectionFactory) ctx
					.lookup("TopicConnectionFactory");
			TopicConnection conn = factory.createTopicConnection();
			TopicSession session = conn.createTopicSession(false,
					TopicSession.AUTO_ACKNOWLEDGE);
			Destination destination = (Destination) ctx
					.lookup("topic/jervalTopic");
			MessageProducer producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage("你好，蹇伟,杰威。");
			producer.send(message);
			session.close();
			conn.close();
			System.out.println("发送完成！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
