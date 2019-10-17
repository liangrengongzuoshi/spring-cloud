package com.liangzai.spcribbon;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
// 熔断
@EnableHystrix
@EnableHystrixDashboard
@ComponentScan(basePackages = "com.liangzai")
public class SpcRibbonApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpcRibbonApplication.class, args);
    }


    /**
     * HystrixDashboard
     * http://localhost:8091/hystrix
     * http://localhost:8091/hystrix.stream
     *
     * 0.访问：
     * http://localhost:8091/hystrix
     *
     * 1.依次输入：
     * http://localhost:8091/hystrix.stream
     * 2000（Delay:ms）
     * miya（title）
     *
     * 2.访问：
     * http://localhost:8091
     *
     * 3.刷新步骤0页面
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
