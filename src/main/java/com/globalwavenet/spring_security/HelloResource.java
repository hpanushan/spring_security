package com.globalwavenet.spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping("/")
    public String sayHello(){
        return "<h1>Hello World! </h1>";
    }

    @GetMapping("/admin")
    public String helloAdmin(){
        return "<h1>Hello Admin! </h1>";
    }

    @GetMapping("/user")
    public String helloUser(){
        return "<h1>Hello User! </h1>";
    }

}
