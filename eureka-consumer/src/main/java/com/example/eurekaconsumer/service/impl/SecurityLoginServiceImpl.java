package com.example.eurekaconsumer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.eurekaconsumer.dao.UsersMapper;
import com.example.eurekaconsumer.entity.LoginUser;
import com.example.eurekaconsumer.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
class SecurityLoginServiceImpl implements UserDetailsService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Users::getUsername, username);
        Users users = usersMapper.selectOne(wrapper);
        if (Objects.isNull(users)) {
            throw new RuntimeException("没有这个用户");
        }
        return new LoginUser(users);
    }
}
