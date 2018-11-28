package com.example.mq.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.mq.dto.User;

@Component
public class Receiver {

    @RabbitListener(queues = "queue-1")
    @RabbitHandler
    public void process(@Payload User user) {
        System.out.println("Receiver : "  + user.getName());
    }

}