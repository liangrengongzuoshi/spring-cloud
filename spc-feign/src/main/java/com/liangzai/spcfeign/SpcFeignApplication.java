package com.liangzai.spcfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = "com.liangzai")
public class SpcFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcFeignApplication.class, args);
    }

}
