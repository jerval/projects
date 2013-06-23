package com.jerval.ejb3.mdb;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
@Remote(MessageSenderService.class)
@Local(MessageSenderService.class)
public class MessageSenderBean implements MessageSenderService {
	@Resource(mappedName = "ConnectionFactory")
	private ConnectionFactory connectionFactory;
	@Resource(mappedName = "queue/rds/generateQueue")
	private Queue queue;

	@Override
	public void sendMessage(String guestName) throws Exception {
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		MessageProducer messageProducer = session.createProducer(queue);
		TextMessage textMessage = session.createTextMessage("Hello "
				+ guestName + ",I am jerval !");
		messageProducer.send(textMessage);
		connection.close();
	}

}
