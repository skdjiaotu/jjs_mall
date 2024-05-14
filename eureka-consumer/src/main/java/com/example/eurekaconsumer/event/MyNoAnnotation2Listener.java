package com.example.eurekaconsumer.event;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyNoAnnotation2Listener implements ApplicationListener<MyTestEvent> {
    @Override
    public void onApplicationEvent(MyTestEvent event) {
        System.out.println("第二个非注解监听器：" + event.getMsg());
    }
}
