package com.globalwavenet.spring_security.controller;

import com.globalwavenet.spring_security.model.AuthRequest;
import com.globalwavenet.spring_security.model.AuthResponse;
import com.globalwavenet.spring_security.model.ResponseMessage;
import com.globalwavenet.spring_security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
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
            return new ResponseEntity<>(new ResponseMessage("invalid username or password"), HttpStatus.UNAUTHORIZED);
        }

        // Generate token
        String token = jwtUtil.generateToken(authRequest.getUserName());

        return ResponseEntity.ok(new AuthResponse(token));
    }


}
