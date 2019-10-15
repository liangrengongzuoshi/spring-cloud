package com.liangzai.spcuser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello world, Hello Eureka, Hello Port-" + port;
    }
}
