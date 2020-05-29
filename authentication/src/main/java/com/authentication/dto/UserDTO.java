package com.authentication.dto;

import com.authentication.model.User;
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

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.status = user.getStatus().toString();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.address=user.getAddress();
    }

}
