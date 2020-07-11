package com.authentication.controller;

import com.authentication.dto.UserDTO;
import com.authentication.model.User;
import com.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(produces="application/json")
    //@PreAuthorize("hasRole('ADMIN')")
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

    @PutMapping(value="/changeStatus", produces = "application/json", consumes = "application/json")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity changeStatus(@RequestBody UserDTO user) {

        try {
            this.userService.changeStatus(user);
            return new ResponseEntity(HttpStatus.OK);

        } catch (NullPointerException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/whoami")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CLIENT','ROLE_AGENT')")
    public User user(Principal user) {
        return this.userService.findByUsername(user.getName());
    }

    @PostMapping("/username")
    public User userByUsername(@RequestBody String username) {
        return this.userService.findByUsername(username);
    }
}
