package com.rent.client;

import com.rent.dto.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "messages")
public interface MessagesClient {

    @GetMapping(value = "/message/rentRequest/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MessageDTO> getMessagesFromRentRequest(@PathVariable("id") String id);
}
