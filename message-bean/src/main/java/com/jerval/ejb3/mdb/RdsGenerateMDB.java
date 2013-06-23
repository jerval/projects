package com.jerval.ejb3.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/rds/generateQueue") })
public class RdsGenerateMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			if (message instanceof ObjectMessage) {
				ObjectMessage objectMessage = (ObjectMessage) message;
				User user = (User) objectMessage.getObject();
				System.out.println("User Info : " + user);
			} else if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				System.out.println("Text Info : " + textMessage.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
