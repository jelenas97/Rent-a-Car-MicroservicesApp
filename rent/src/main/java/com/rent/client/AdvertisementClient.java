package com.rent.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "advertisement")
public interface AdvertisementClient {

    @GetMapping("/advertisement/test")
    String getAdvertisement();
}
