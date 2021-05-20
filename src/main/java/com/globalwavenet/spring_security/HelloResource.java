package com.globalwavenet.spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping("/hello")
    public String sayHello(){
        return "<h1>Hello World! </h1>";
    }

}
