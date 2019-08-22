package com.example.xmljmsSender.jms;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageToQueue {

    private static List<String> message = new ArrayList();

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(String message) {
        MessageToQueue.message.add(message);
    }
}
