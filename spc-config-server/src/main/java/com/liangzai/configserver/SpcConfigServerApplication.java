package com.liangzai.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@EnableDiscoveryClient
public class SpcConfigServerApplication {

    /**
     * 配置文件名：config-dev.properties,config-pro.properties
     * http://localhost:8070/config/dev/master 或 http://localhost:8070/config-dev.properties
     * http://localhost:8070/config/test/master
     * http://localhost:8070/config/pro/master
     *
     * http://localhost:8070/config.client.message/dev
     *
     */
    public static void main(String[] args) {
        SpringApplication.run(SpcConfigServerApplication.class, args);
    }

}
