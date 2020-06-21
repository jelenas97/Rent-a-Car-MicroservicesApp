package com.advertisement.client;

import com.advertisement.dto.CommentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "statistics")
public interface StatisticClient {

    @GetMapping(value="/comment/{id}", produces="application/json")
    ResponseEntity<List<CommentDTO>> getProcessedAdvertisementComments(@PathVariable Long id);
}
