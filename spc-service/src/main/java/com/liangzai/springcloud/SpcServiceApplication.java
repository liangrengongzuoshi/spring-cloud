package com.liangzai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaServer
@ComponentScan(basePackages = "com.liangzai")
public class SpcServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcServiceApplication.class, args);
    }

}
