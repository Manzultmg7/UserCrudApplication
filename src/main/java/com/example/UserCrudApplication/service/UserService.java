package com.example.UserCrudApplication.service;

import com.example.UserCrudApplication.controller.request.UserRequest;
import com.example.UserCrudApplication.model.User;
import com.example.UserCrudApplication.repository.UserRepository;
import jakarta.transaction.Transactional;
import jdk.dynalink.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Transactional
    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setUserAddress(userRequest.getUserAddress());
        user.setUserEmail(userRequest.getUserEmail());
        return userRepository.save(user);
    }
    public List<User> getAllUser(){
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }
    public User getUserById(Long userId){
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);

    }
}
