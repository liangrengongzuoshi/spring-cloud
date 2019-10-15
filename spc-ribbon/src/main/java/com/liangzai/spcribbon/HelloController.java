package com.liangzai.spcribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    /**
     * 熔断，系统异常调用，helloError接口
     */
    @HystrixCommand(fallbackMethod = "helloError")
    public String hello() {
        return restTemplate.getForEntity("http://spc.liangzai.user/", String.class).getBody();
    }

    public String helloError() {
        return "Hystrix : spc.liangzai.ribbon call spc.liangzai.user error.";
    }
}
