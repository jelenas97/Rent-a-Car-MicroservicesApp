package com.advertisement.client;

import com.advertisement.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "authentication")
public interface AuthenticationClient {

    @GetMapping("/user/{id}")
    UserDTO findById(Long ownerId);
}
