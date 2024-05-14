package com.example.eurekaconsumer.controller;

import com.example.eurekaconsumer.dto.Store;
import com.example.eurekaconsumer.event.MyEventPublisher;
import com.example.eurekaconsumer.feignclient.ProducerClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    MyEventPublisher  publisher;

    @RequestMapping("hello")
    public String index() {
        return "hello";
    }

    @RequestMapping("publish")
    public String publish(){
        publisher.publishEvent();
        return "Ok";
    }
}
