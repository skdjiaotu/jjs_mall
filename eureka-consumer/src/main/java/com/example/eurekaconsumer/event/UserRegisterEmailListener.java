package com.example.eurekaconsumer.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterEmailListener implements ApplicationListener<UserDTO> {
    @Override
    public void onApplicationEvent(UserDTO userDTO){
        System.out.println("监听到用户注册，准备发送邮件，user:" + userDTO.toString());
    }
}
