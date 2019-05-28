package com.zh.notif.handle;

import com.zh.notif.util.ClassScanner;
import com.zh.notif.util.HelloType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@SuppressWarnings("unchecked")
public class HelloProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLE_PACKAGE = "com.zh.notif.serviceImp";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        Map<Byte,Class> handleMap = new HashMap<>(3);
        try {
            ClassScanner.scan(HANDLE_PACKAGE, HelloType.class).get(HelloType.class).forEach(clazz->{
                Byte type = clazz.getAnnotation(HelloType.class).value();
                handleMap.put(type,clazz);
            });
            HandleContext handleContext = new HandleContext(handleMap);
            configurableListableBeanFactory.registerSingleton(HandleContext.class.getName(),handleContext);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
