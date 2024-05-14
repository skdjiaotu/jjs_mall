package com.example.eurekaproducer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("sayHello")
    public String sayHello() {
        return "Hello2";
    }

    @RequestMapping("stores")
    public String stores() throws InterruptedException {
        Thread.sleep(5000L);
        return "Hello2List";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
    public Long storesList(@PathVariable Long storeId) {
        return storeId;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/stores/{storeId:\\d+}")
    public Long deleteStores(@PathVariable Long storeId) {
        return storeId;
    }



}
