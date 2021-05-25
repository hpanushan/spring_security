package com.globalwavenet.spring_security.controller;

import com.globalwavenet.spring_security.model.ResponseMessage;
import com.globalwavenet.spring_security.entity.User;
import com.globalwavenet.spring_security.model.UserGetResponse;
import com.globalwavenet.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserManagementController {

    @Autowired
    private UserService userService;

    // For get user details
    @GetMapping("/user")
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
    @PostMapping("/user")
    public ResponseMessage addUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseMessage("user added");
    }

    // For update users
    @PutMapping("/user")
    public ResponseMessage updateUser(@RequestBody User user){
        // Extract id from user object
        int id = user.getId();
        userService.updateUser(id,user);
        return new ResponseMessage("user updated");
    }

    // For delete users
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        try{
            userService.deleteById(id);
        }catch (Exception e){
            return new ResponseEntity<>(new ResponseMessage("invalid user"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new ResponseMessage("user removed"));
    }


}
