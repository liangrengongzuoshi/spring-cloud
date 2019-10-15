package com.liangzai.spcfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "spc.liangzai.user",fallback = ServiceHelloHystric.class)
public interface ServiceHello {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String sayHello();
}
