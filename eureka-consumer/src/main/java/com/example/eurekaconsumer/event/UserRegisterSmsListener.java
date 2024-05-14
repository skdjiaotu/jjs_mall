package com.example.eurekaconsumer.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterSmsListener {
    // 通过注解实现监听器
    @Order(-1)
    @Async("asyncThreadPool")
    @EventListener
    public void handleUserEvent(UserDTO userDTO){
        System.out.println("监听到用户注册，准备发送短信，user:"+userDTO.toString());
    }
}
