package com.example.UserCrudApplication.controller.request;


import jakarta.validation.constraints.*;

public class UserRequest {


    @NotEmpty
    @Size(min=5, max=20)
    private String userName;
    @NotBlank(message="email is required!!!")
    @Email(message = "please enter valid email")
    private String userEmail;
    @NotEmpty
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
