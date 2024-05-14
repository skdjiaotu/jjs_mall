package com.example.eurekaconsumer.event;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class MyNoAnnotationListener implements ApplicationListener<MyTestEvent> {
    @Override
    public void onApplicationEvent(MyTestEvent event) {
        System.out.println("非注解监听器：" + event.getMsg());
    }
}
