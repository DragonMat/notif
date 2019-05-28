package com.zh.notif.controller;

import com.zh.notif.model.HelloVO;
import com.zh.notif.service.AbstractHelloHandler;
import com.zh.notif.service.HelloHandlerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    HelloHandlerService helloHandlerService;

    @PostMapping("/index/hello")
    public String sayHello(@RequestBody HelloVO helloVO){

       return helloHandlerService.handleSayHello(helloVO.getType());
    }


}
