package com.globalwavenet.spring_security.repository;

import com.globalwavenet.spring_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserName(String userName);
}
