package com.example.UserCrudApplication.controller.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserRequest {

    @Valid
    @NotEmpty
    private String userName;
    @NotNull
    @Email
    private String userEmail;
    @NotBlank
    private String userAddress;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public UserRequest(String userName, String userEmail, String userAddress) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
    }
}
