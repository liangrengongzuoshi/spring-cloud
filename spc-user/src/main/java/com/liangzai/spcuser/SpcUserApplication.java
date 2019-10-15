package com.liangzai.spcuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.liangzai")
public class SpcUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcUserApplication.class, args);
    }

}
