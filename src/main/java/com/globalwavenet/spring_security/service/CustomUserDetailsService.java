package com.globalwavenet.spring_security.service;

import com.globalwavenet.spring_security.model.CustomUserDetails;
import com.globalwavenet.spring_security.entity.User;
import com.globalwavenet.spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByUserName(userName));

        user.orElseThrow(() -> new UsernameNotFoundException("Not found " + userName));

        return user.map(CustomUserDetails::new).get();

    }
}
