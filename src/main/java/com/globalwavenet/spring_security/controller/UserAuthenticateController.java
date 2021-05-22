package com.globalwavenet.spring_security.controller;

import com.globalwavenet.spring_security.entity.AuthRequest;
import com.globalwavenet.spring_security.entity.AuthResponse;
import com.globalwavenet.spring_security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserAuthenticateController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        }catch (Exception e){
            throw new Exception("invalid username or password");
        }

        // Generate token
        String token = jwtUtil.generateToken(authRequest.getUserName());

        return ResponseEntity.ok(new AuthResponse(token));
    }


}
