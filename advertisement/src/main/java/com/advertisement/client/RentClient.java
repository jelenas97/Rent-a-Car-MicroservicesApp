package com.advertisement.client;

import com.advertisement.dto.ExtraPayDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "rent")
public interface RentClient {

    @PostMapping(value = "rentRequest/extraPay", produces = "application/json" )
    void addExtraPay(@RequestBody ExtraPayDTO dto);

}
