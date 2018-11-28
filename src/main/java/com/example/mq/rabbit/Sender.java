package com.example.mq.rabbit;

import java.util.Date;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mq.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void send() throws JsonProcessingException {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        User user = new User();
        user.setId(1);
        user.setName("Justin");
        this.rabbitTemplate.convertAndSend("queue-1", user);
    }

}
