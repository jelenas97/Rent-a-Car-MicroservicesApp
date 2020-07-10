package com.rent.client;

import com.rent.dto.CommentAndRateDTO;
import com.rent.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authentication")
public interface UserClient{

    @GetMapping("user/{id}")
    UserDTO getUser(@PathVariable String id);

}