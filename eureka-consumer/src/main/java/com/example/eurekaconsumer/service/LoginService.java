package com.example.eurekaconsumer.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.eurekaconsumer.entity.Users;
import com.example.eurekaconsumer.event.UserService;

/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2024-05-10 17:41:55
 */
public interface LoginService extends IService<Users> {
    String login(Users users);
}

