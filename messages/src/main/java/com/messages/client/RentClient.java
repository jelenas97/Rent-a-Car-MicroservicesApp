package com.messages.client;

import com.messages.dto.RentRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "rent")
public interface RentClient {
    @GetMapping(value = "rentRequest/{id}", produces = "application/json" )
    RentRequestDTO getRentRequest(@PathVariable("id") String id);
}
