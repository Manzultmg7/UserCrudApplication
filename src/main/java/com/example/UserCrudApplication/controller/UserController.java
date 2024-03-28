package com.example.UserCrudApplication.controller;

import com.example.UserCrudApplication.controller.request.UserRequest;
import com.example.UserCrudApplication.model.User;
import com.example.UserCrudApplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/users")
    public User createNewUser(@Valid @RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);

    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {

        return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.OK);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable long userId){
        User user= userService.getUserById(userId);
        if(user!= null){
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
