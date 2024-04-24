package com.example.UserCrudApplication.dto;


import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotEmpty
    @Size(min=5, max=20)
    private String userName;
    @NotBlank(message="email is required!!!")
    @Email(message = "please enter valid email")
    private String userEmail;
    @NotEmpty
    private String userAddress;

}
