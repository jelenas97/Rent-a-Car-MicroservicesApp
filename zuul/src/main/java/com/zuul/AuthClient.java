package com.zuul;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "authentication")
public interface AuthClient {

    @PostMapping(value = "/auth/verify", consumes = "text/plain")
    boolean verify(@RequestBody String token);
}
