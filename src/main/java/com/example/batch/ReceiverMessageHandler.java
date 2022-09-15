package com.example.batch;

import com.example.batch.data.ExampleData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ReceiverMessageHandler implements MessageHandler {
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        ExampleData messageContainer = null;
        try {
            messageContainer =  mapper.readValue((byte[]) message.getPayload(), ExampleData.class);
            System.out.println(messageContainer.getXx());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(messageContainer.getXx());
    }
}
