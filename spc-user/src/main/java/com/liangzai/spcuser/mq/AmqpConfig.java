package com.liangzai.spcuser.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

	public static final String EXCHANGE = "delayed_exchange";

	public static final String KEY = "kreditplus.apply.test.delay";

    @Bean
    public ContentTypeDelegatingMessageConverter messageConverter() {
		SimpleMessageConverter simpleConverter = new SimpleMessageConverter();
    	ContentTypeDelegatingMessageConverter converter = new ContentTypeDelegatingMessageConverter(simpleConverter);
		converter.addDelegate("application/json", new Jackson2JsonMessageConverter());
        return converter;
    }

	/**
	 * 延时队列交换机
	 */
	@Bean
	public DirectExchange deplayedExchange() {
		DirectExchange directExchange = new DirectExchange(EXCHANGE, true, false);
		directExchange.setDelayed(true);
		return directExchange;
	}

	/**
	 * 延时队列
	 */
	@Bean
	public Queue delayQueue(){
		return new Queue(KEY,true);
	}

	/**
	 * 给延时队列绑定交换机
	 */
	@Bean
	public Binding bindingDelayQueue() {
		return BindingBuilder.bind(delayQueue()).to(deplayedExchange()).withQueueName();
	}

}
