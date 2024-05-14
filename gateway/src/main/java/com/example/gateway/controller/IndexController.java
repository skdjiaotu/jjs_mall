package com.example.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("index")
    public String sayHello() {
        return "index";
    }

    @RequestMapping("stores")
    public String stores() {
        return "Hello2List";
    }

}
