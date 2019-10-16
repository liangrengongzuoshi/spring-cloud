package com.liangzai.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${config.client.message}")
    String message;

    @RequestMapping(value = "/message")
    public String message() {
        return message;
    }

}
