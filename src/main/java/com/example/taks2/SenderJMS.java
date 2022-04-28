package com.example.taks2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ibm")
public class SenderJMS {

    @Autowired
    private JmsTemplate jmsTemplateSender;

    @PostMapping(value = "/{request}")
    public String sendMessage(@PathVariable String request) {
        Message message = new Message();
        message.setContent(request);
        jmsTemplateSender.convertAndSend("senla", message);
        return "JMS: Message sent Successfully to the topic";
    }
}
