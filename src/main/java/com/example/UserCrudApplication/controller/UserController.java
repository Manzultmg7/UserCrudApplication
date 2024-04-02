package com.example.UserCrudApplication.controller;

import com.example.UserCrudApplication.controller.request.UserRequest;
import com.example.UserCrudApplication.model.User;
import com.example.UserCrudApplication.service.UserServiceImp;
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
    UserServiceImp userServiceImp;

    @PostMapping("/users")
    public User createNewUser(@Valid @RequestBody UserRequest userRequest) {
        return userServiceImp.createUser(userRequest);

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userServiceImp.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }


    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable long userId) {
        User userRequest = userServiceImp.getUserById(userId);
        if (userRequest != null) {
            return new ResponseEntity<User>(userRequest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @Valid @RequestBody User user) {
        User updatedUser = userServiceImp.updateUser(userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUserById(@PathVariable long userId) {
        return userServiceImp.deleteUserById(userId);
    }

    @DeleteMapping("/users")
    public String deleteAllUsers() {
        return userServiceImp.deleteAllUsers();
    }

}
