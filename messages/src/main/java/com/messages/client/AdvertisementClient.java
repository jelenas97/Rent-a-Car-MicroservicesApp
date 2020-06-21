package com.messages.client;

import com.messages.dto.AdvertisementDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "advertisement")
public interface AdvertisementClient {
    @GetMapping(value = "advertisement/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    AdvertisementDTO getAdvertisement(@PathVariable Long id);
}
