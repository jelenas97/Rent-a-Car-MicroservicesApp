package com.authentication.controller;

import com.authentication.model.User;
import com.authentication.service.AuthorityService;
import com.authentication.service.UserService;
import com.authentication.dto.UserDTO;
import com.authentication.dto.UserTokenState;
import com.authentication.model.User;
import com.authentication.security.TokenUtils;
import com.authentication.security.auth.JwtAuthenticationRequest;
import com.authentication.service.UserService;
import com.authentication.service.impl.CustomUserDetailsService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {
    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;



    // Prvi endpoint koji pogadja korisnik kada se loguje.
    // Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
                                                                    HttpServletResponse response) {

        //
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()));

        // Ubaci korisnika u trenutni security kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token za tog korisnika
        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getUsername());
        int expiresIn = tokenUtils.getExpiredIn();

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setStatus(user.getStatus().toString());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAddress(user.getAddress());

        ArrayList<String> roles = new ArrayList<>();

        for (GrantedAuthority authority : user.getAuthorities()) {
            roles.add(authority.getAuthority());
        }
        userDTO.setRoles(roles);

        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn, userDTO));
    }

    @PostMapping(value = "/refresh")
    public ResponseEntity<UserTokenState> refreshAuthenticationToken(HttpServletRequest request) {

        String token = tokenUtils.getToken(request);
        String username = this.tokenUtils.getUsernameFromToken(token);
        User user = (User) this.userDetailsService.loadUserByUsername(username);

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setStatus(user.getStatus().toString());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());

        ArrayList<String> roles = new ArrayList<>();

        for (GrantedAuthority authority : user.getAuthorities()) {
            roles.add(authority.getAuthority());
        }
        userDTO.setRoles(roles);

        if (this.tokenUtils.canTokenBeRefreshed(token)) {
            String refreshedToken = tokenUtils.refreshToken(token);
            int expiresIn = tokenUtils.getExpiredIn();

            return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn, userDTO));
        } else {
            UserTokenState userTokenState = new UserTokenState();
            return ResponseEntity.badRequest().body(userTokenState);
        }
    }

    @PostMapping(value = "/verify" ,consumes = "text/plain")
    public boolean verify(@RequestBody String token){
        String username = tokenUtils.getUsernameFromToken(token);
        System.out.print("VERIFIKACIJA");
        System.out.print(token);
        System.out.print(username);

        if (username == null){
            return false;
        }
        UserDetails user = userDetailsService.loadUserByUsername(username);
        System.out.print(user);

        if (user == null){
            return false;
        }

        if (tokenUtils.validateToken(token, user)) {
            return true;
        } else {
            return false;
        }
    }

}
