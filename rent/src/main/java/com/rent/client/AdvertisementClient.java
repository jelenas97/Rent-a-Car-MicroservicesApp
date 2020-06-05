package com.rent.client;

import com.rent.dto.AdvertisementDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "advertisement")
public interface AdvertisementClient {

    @GetMapping("/advertisement")
    AdvertisementDTO getAdvertisement();

    @GetMapping("/advertisement/owner/{id}")
    List<AdvertisementDTO> getUserAdvertisements(@PathVariable Long id);
}
