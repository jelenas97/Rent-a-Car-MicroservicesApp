package com.authentication.service.impl;

import com.authentication.dto.UserDTO;
import com.authentication.enumerations.AccountStatus;
import com.authentication.model.Authority;
import com.authentication.model.Client;
import com.authentication.model.User;
import com.authentication.repository.UserRepository;
import com.authentication.service.AuthorityService;
import com.authentication.service.UserService;

import com.authentication.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAllUsers() {
        this.userRepository.findAllUsers();
        List<UserDTO> users = new ArrayList<>();
        for (User u : this.userRepository.findAllUsers()) {
            users.add(new UserDTO(u));
        }
        return users;
    }

    @Override
    public void changeStatus(UserDTO userDTO) {
        User user = this.userRepository.findByEmail(userDTO.getEmail());
        user.setStatus(AccountStatus.valueOf(userDTO.getStatus()));
        this.userRepository.save(user);

    }

    @Override
    public User findOne(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public Client save(UserDTO userDTO) {
        Client client = new Client();
        client.setFirstName(userDTO.getFirstName());
        client.setLastName(userDTO.getLastName());
        client.setStatus(AccountStatus.ACTIVE);
        client.setEmail(userDTO.getEmail());
        client.setUsername(userDTO.getUsername());

        if (userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            client.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }

        List<Authority> auth = authorityService.findByName("ROLE_CLIENT");
        client.setAuthorities(auth);

        userRepository.save(client);

        return client;
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findOneById(id);
    }
}
