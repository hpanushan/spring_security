package com.globalwavenet.spring_security.service;

import com.globalwavenet.spring_security.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public void updateUser(Integer id,User user);

    public void deleteById(Integer id);

    public Boolean userExists(User user);

}
