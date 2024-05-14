package com.example.eurekaconsumer.controller;

import com.example.eurekaconsumer.event.MyTestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testEventController")
public class MyTestEventController {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping(value = "/testPublishEvent1" )
    public void testPublishEvent(){
        applicationEventPublisher.publishEvent(new MyTestEvent(this, "我来了"));
    }
}
