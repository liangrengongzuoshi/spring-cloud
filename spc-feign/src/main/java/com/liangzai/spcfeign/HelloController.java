package com.liangzai.spcfeign;

import com.liangzai.spcfeign.feign.ServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Autowired
    ServiceHello serivce;

    @RequestMapping("/")
    public String hello() {
        return serivce.sayHello();
    }

}
