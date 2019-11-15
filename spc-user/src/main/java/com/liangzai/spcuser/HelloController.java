package com.liangzai.spcuser;

import com.liangzai.spcuser.mq.Send;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    Send send;

    @RequestMapping("/send")
    @ResponseBody
    public String sendMsg(String msg, Integer delay){
        System.out.println("/send：" + msg + "：" +delay);
        send.send(msg, delay);
        return msg + "-" + delay;
    }

}
