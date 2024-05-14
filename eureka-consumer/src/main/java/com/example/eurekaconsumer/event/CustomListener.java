package com.example.eurekaconsumer.event;

import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomListener {
    @EventListener(classes = {MyEvent.class})
    public void listen(MyEvent event) {
        System.out.println("注解事件触发：" + event.getClass().getName());
    }
}
