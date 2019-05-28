package com.zh.notif.serviceImp;

import com.zh.notif.service.AbstractHelloHandler;
import com.zh.notif.util.HelloType;
import org.springframework.stereotype.Component;

@Component
@HelloType(1)
public class MorningHello extends AbstractHelloHandler {

    @Override
    public String handleHello(Byte type) {
        return "good morning";
    }
}
