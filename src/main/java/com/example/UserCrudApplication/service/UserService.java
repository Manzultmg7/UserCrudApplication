package com.example.UserCrudApplication.service;

import com.example.UserCrudApplication.controller.request.UserRequest;
import com.example.UserCrudApplication.model.User;

import java.util.List;

public interface UserService {
    public User createUser(UserRequest userRequest);
    public List<User> getAllUser();
    public User getUserById(Long userId);
    public User updateUser(Long userId, User userDetails);
    public void deleteUserById(Long userId);
    public void deleteAllUsers();
}
