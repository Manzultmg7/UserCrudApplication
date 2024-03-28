package com.example.UserCrudApplication.service;

import com.example.UserCrudApplication.controller.request.UserRequest;
import com.example.UserCrudApplication.model.User;
import com.example.UserCrudApplication.repository.UserRepository;
import jakarta.transaction.Transactional;
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

    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);

    }


    public User updateUser(Long userId, User userDetails) {
        User user = getUserById(userId);
        if (user != null) {
            user.setUserName(userDetails.getUserName());
            user.setUserEmail(userDetails.getUserEmail());
            user.setUserAddress(userDetails.getUserAddress());

            return userRepository.save(user);
        }
        return null;
    }

    public String deleteUserById(Long userId) {
        userRepository.deleteById(userId);

        return "User with id " + userId + " deleted";
    }

    public String deleteAllUsers() {
        userRepository.deleteAll();
        return "all users deleted successfully ";
    }
}
