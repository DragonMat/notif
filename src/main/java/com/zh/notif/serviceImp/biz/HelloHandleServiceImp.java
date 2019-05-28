package com.zh.notif.serviceImp.biz;

import com.zh.notif.handle.HandleContext;
import com.zh.notif.service.AbstractHelloHandler;
import com.zh.notif.service.HelloHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloHandleServiceImp implements HelloHandlerService {

    @Autowired
    private HandleContext handleContext;


    @Override
    public String handleSayHello(Byte type) {
        AbstractHelloHandler helloHandler = null;
        try {
            helloHandler = handleContext.getInstance(type);
            return helloHandler.handleHello(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
