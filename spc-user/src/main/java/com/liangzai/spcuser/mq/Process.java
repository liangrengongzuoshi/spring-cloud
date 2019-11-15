package com.liangzai.spcuser.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Process {

    @NewSpan
    @RabbitListener(queues = AmqpConfig.KEY)
    public void process(String msg) {
        System.out.println("接收消息：" + LocalDateTime.now());
        System.out.println("消息：" + msg);
    }

}
