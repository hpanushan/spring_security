package com.globalwavenet.spring_security;

import com.globalwavenet.spring_security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUserName(String userName);
}
