package com.zh.notif.handle;

import com.zh.notif.service.AbstractHelloHandler;

import java.util.Map;
import java.util.Objects;

public class HandleContext {

    Map<Byte, Class> handlerMap;

    public HandleContext(Map<Byte, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }

    public AbstractHelloHandler getInstance(Byte type) throws Exception {
        Class instance = handlerMap.get(type);
        if (Objects.isNull(instance)) {
            throw new Exception("获取类型处理失败：" + type);
        }
        return (AbstractHelloHandler)BeanTool.getBean(instance);
    }
}
