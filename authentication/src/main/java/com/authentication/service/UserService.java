package com.authentication.service;

import com.authentication.model.User;
import com.authentication.dto.UserDTO;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();

    void changeStatus(UserDTO user);

    User findOne(String email);

    User findByUsername(String username) throws UsernameNotFoundException;

    User save(User user);

    User findById(Long id);

}
