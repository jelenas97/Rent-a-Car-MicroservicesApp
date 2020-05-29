package com.zuul;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "authentication")
public interface AuthClient {

    @GetMapping("/auth/verify/{token}")
    boolean verify(@PathVariable String token);
}
