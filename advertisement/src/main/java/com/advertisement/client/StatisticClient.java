package com.advertisement.client;

import com.advertisement.dto.CommentDTO;
import com.advertisement.dto.RateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.security.PermitAll;
import java.util.List;

@FeignClient(name = "statistics")
public interface StatisticClient {

    @GetMapping(value="/comment/{id}", produces="application/json")
    ResponseEntity<List<CommentDTO>> getProcessedAdvertisementComments(@PathVariable Long id);

    @GetMapping(value="/rate/{id}/first", produces="application/json")
    @PermitAll
    RateDTO getAverageAdvertisementRateFirst(@PathVariable Long id);
}
