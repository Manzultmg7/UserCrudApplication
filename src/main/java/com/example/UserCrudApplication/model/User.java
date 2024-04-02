package com.example.UserCrudApplication.model;

import jakarta.persistence.*;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String userEmail;
    @Column(name = "address")
    private String userAddress;

}
