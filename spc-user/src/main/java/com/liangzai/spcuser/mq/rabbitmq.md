#### rabbitmq

##### 延迟消息
```
# 安装插件：rabbitmq_delayed_message_exchange
http://www.rabbitmq.com/community-plugins.html
# 需和rabbitmq版本对应

# 放置到RabbitMQ安装目录下的plugins目录

# 启动：
rabbitmq-plugins enable rabbitmq_delayed_message_exchange


<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>

spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
spring.rabbitmq.virtualHost=kk_dev
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest

```

