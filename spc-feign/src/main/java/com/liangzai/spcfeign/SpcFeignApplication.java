package com.liangzai.spcfeign;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard
@ComponentScan(basePackages = "com.liangzai")
public class SpcFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcFeignApplication.class, args);
    }

    /**
     * HystrixDashboard
     * http://localhost:8092/hystrix
     * http://localhost:8092/hystrix.stream
     *
     * 0.访问：
     * http://localhost:8092/hystrix
     *
     * 1.依次输入：
     * http://localhost:8092/hystrix.stream
     * 2000（Delay:ms）
     * feign（title）
     *
     * 2.访问：
     * http://localhost:8092
     *
     * 3.刷新步骤0页面
     *
     * 4.不断刷新2步骤，即可看到3页面图表变更
     *
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
