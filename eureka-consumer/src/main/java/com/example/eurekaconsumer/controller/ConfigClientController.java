package com.example.eurekaconsumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigClientController {

    @Value("${info.profile}")
    private String profile; //获取Eureka服务

    @Value("${info.from}")
    private String from; //获取Eureka服务

    @Value("${test}")
    private String test; //获取Eureka服务


    @RequestMapping("getCloudConfig")
    public Map<String, Object> getConfigByCloud() {
        Map<String, Object> resp = new HashMap<>();
        resp.put("profile", profile);
        resp.put("from", from);
        resp.put("test", test);


        return resp;
    }
}
