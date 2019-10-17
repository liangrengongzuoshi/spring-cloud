package com.liangzai.zipkin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ZipkinController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello world, Hello Zipkin, Hello Port-" + port;
    }
}
