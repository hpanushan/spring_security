package com.globalwavenet.spring_security.controller;

import com.globalwavenet.spring_security.entity.AuthRequest;
import com.globalwavenet.spring_security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String hello(){
        return "<h1>Hello World<h1>";
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        }catch (Exception e){
            throw new Exception("invalid username or password");
        }

        // Generate token
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
