package com.maven.springboot.demo.server;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 只为了 测试  aop  
 */
@RestController
public class TestController {


    @GetMapping(value="/test1")
    public String requestMethodName(@RequestParam(value = "name") String name) {
        return String.format("hello %s", name);
    }
    
    
}