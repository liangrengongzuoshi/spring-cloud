package com.liangzai.spcfeign.feign;

import org.springframework.stereotype.Component;

@Component
public class ServiceHelloHystric implements ServiceHello {

    @Override
    public String sayHello() {
        return "Hystrix : spc.liangzai.feign call spc.liangzai.user error.";
    }

}
