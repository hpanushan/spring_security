package com.globalwavenet.spring_security.controller;

import com.globalwavenet.spring_security.entity.User;
import com.globalwavenet.spring_security.entity.UserGetResponse;
import com.globalwavenet.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserManagementController {

    @Autowired
    private UserService userService;

    // For get user details
    @GetMapping("/get")
    public ResponseEntity<?> findAllUsers(){
        List<User> userDetails = userService.getAllUsers();

        ArrayList<UserGetResponse> response = new ArrayList<UserGetResponse>(); // Create an ArrayList object

        for (User user : userDetails)
        {
            UserGetResponse userResponse = new UserGetResponse();
            userResponse.setId(user.getId());
            userResponse.setFname(user.getFname());
            userResponse.setLname(user.getLname());
            userResponse.setUserName(user.getUserName());
            userResponse.setRole(user.getRole());
            userResponse.setActive(user.getActive());

            // Add new object to array list
            response.add(userResponse);
        }
        return ResponseEntity.ok(response);
    }

    // For add new users
    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.saveUser(user);
    }

    // For update users
    @PutMapping("/update")
    public void updateUser(@RequestBody User user){
        // Extract id from user object
        int id = user.getId();
        userService.updateUser(id,user);
    }

    // For delete users
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteById(id);
    }

}
