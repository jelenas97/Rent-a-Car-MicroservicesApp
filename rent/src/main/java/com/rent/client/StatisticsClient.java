package com.rent.client;

import com.rent.dto.AdvertisementDTO;
import com.rent.dto.CommentAndRateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "statistics")
public interface StatisticsClient {

    @GetMapping("aggregate/commentAndRate/{id}")
    CommentAndRateDTO getCommentsAndRates(@PathVariable Long id);

}
