package com.example.taks2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateStringIBM;

    @JmsListener(destination = "senla")
    public void receiveMessage(Message msg) {
        System.out.println("JMS: Received " + msg);
        System.out.println("========");
        System.out.println("JMS: Send to kafka");
        kafkaTemplateStringIBM.send("stringibm",msg.getContent());
    }
}
