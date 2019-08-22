package com.example.xmljmsSender.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.UncategorizedJmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class Sender implements SendJms {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    public void sendStringMsg(String message) {

        try {
            jmsTemplate.convertAndSend(queue, message);
            System.out.println(" message has been sent successfully: " + message);
        } catch (UncategorizedJmsException e) {
            throw new RuntimeException(e);
        }


    }


}
