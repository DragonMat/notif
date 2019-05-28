package com.zh.notif.serviceImp;

import com.zh.notif.service.AbstractHelloHandler;
import com.zh.notif.service.HelloHandlerService;
import com.zh.notif.util.HelloType;
import org.springframework.stereotype.Component;

@Component
@HelloType(2)
public class NoonHello extends AbstractHelloHandler {

    @Override
    public String handleHello(Byte type) {
        return "good noon";
    }
}
