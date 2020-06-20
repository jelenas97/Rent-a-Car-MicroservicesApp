package com.rent.client;

import com.rent.dto.AdvertisementDTO;
import com.rent.dto.TermDTO;
import com.rent.dto.TermSearchDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "advertisement")
public interface AdvertisementClient {

    @GetMapping("/advertisement/{id}")
    AdvertisementDTO getAdvertisement(@PathVariable Long id);

    @GetMapping("/advertisement/owner/{id}")
    List<AdvertisementDTO> getUserAdvertisements(@PathVariable Long id);

    @PostMapping("/term/getTakenTerms")
    List<TermDTO> getTakenTerms(@RequestBody TermSearchDTO termSearchDTO);

    @GetMapping("advertisement/{id}/class")
    String getRentRequestsCarClass(@PathVariable Long id);

}
