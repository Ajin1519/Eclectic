package com.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */
@RestController
@RequestMapping("/")
public class HelloController {
    @RequestMapping("hello")
    public String sayHello(){
        return "Hello";
    }
}