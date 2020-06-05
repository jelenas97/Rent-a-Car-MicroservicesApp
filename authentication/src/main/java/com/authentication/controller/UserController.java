package com.authentication.controller;

import com.authentication.dto.UserDTO;
import com.authentication.model.User;
import com.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(produces="application/json")
    public ResponseEntity<?> getUsers(){

        try {
            List<UserDTO> users = this.userService.findAllUsers();

            return new ResponseEntity(users, HttpStatus.OK);

        }catch(NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error while loading users");
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json" )
    public UserDTO getUser(@PathVariable("id") String id){
        User user = this.userService.findById(Long.parseLong(id));
        UserDTO userDTO = new UserDTO(user);
        return userDTO;
    }

}
