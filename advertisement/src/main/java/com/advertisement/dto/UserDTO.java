package com.advertisement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String status;
    private String username;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String address;
    private List<String> roles;


}
