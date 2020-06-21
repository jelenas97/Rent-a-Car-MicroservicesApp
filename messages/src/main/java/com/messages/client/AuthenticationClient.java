package com.messages.client;

import com.messages.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authentication")
public interface AuthenticationClient {

    @GetMapping(value = "/user/{id}", produces = "application/json" )
    UserDTO getUser(@PathVariable("id") String id);
}
