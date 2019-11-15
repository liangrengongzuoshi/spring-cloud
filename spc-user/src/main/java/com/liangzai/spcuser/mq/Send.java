package com.liangzai.spcuser.mq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class Send {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 延迟消息
     * @param msg 消息
     * @param delayTime 延迟ms
     */
    public void send(String msg, Integer delayTime) {
        System.out.println("发送消息：" + LocalDateTime.now());
        rabbitTemplate.convertAndSend(AmqpConfig.EXCHANGE, AmqpConfig.KEY, msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setDelay(delayTime);
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            }
        });
    }

}
