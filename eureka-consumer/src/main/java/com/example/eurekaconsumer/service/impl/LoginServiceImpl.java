package com.example.eurekaconsumer.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.eurekaconsumer.dao.UsersMapper;
import com.example.eurekaconsumer.entity.LoginUser;
import com.example.eurekaconsumer.entity.Users;
import com.example.eurekaconsumer.service.LoginService;
import com.example.eurekaconsumer.util.JwtTokenUtil;
import com.google.common.base.Verify;
import com.netflix.servo.util.Preconditions;
import org.apache.http.util.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.jar.JarEntry;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2024-05-10 17:41:55
 */
@DS("slave")
@Service("usersService")
public class LoginServiceImpl extends ServiceImpl<UsersMapper, Users> implements LoginService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String login(Users users) {
        //用户认证
        String token = null;
        //密码需要客户端加密后传递
        System.out.println(passwordEncoder.encode("sdfsdfsdf"));
        try {
            UsernamePasswordAuthenticationToken authentication
                    = new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword());
            Authentication authenticate = authenticationManager.authenticate(authentication);

            // 认证通过，生成jjwt
            LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
            // 添加用户id 和 字符串”lalala“ 生成jjwt
            token = jwtTokenUtil.generateToken(loginUser);

        } catch (AuthenticationException e) {
            // LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

}

