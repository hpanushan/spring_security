package com.globalwavenet.spring_security.service;

import com.globalwavenet.spring_security.entity.User;
import com.globalwavenet.spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        String pw = user.getPassword();
        String encodedPassword = passwordEncoder.encode(pw);

        // Set new encoded password
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public void updateUser(Integer id,User user){
        User userFromDb = userRepository.findById(id).get();
        userFromDb.setFname(user.getFname());
        userFromDb.setLname(user.getLname());
        userFromDb.setUserName(user.getUserName());
        userFromDb.setRole(user.getRole());
        userFromDb.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(userFromDb);
    }

    @Override
    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

    @Override
    public Boolean userExists(User user){
        String userName = user.getUserName();
        User dbuser = userRepository.findByUserName(userName);
        if (dbuser!=null){
            return true;
        }
        else {
            return false;
        }
    };
}
