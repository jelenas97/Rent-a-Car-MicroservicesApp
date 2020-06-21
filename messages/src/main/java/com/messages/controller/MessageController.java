package com.messages.controller;

import com.messages.client.AdvertisementClient;
import com.messages.client.RentClient;
import com.messages.dto.AdvertisementDTO;
import com.messages.dto.MessageDTO;
import com.messages.dto.RentRequestDTO;
import com.messages.model.Message;
import com.messages.service.MessageService;
import com.messages.soap.code.PostMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "message")
@CrossOrigin("http://localhost:4200")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private RentClient rentClient;

    @Autowired
    private AdvertisementClient advertisementClient;

    @GetMapping(value = "/rentRequest/{id}/user/{id2}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAuthority('ROLE_AGENT') or hasAuthority('ROLE_CLIENT')")
    public ResponseEntity<List<MessageDTO>> getMessagesRentRequest(@PathVariable("id") String id, @PathVariable("id2") String id2) {

        try {
            List<MessageDTO> list = new ArrayList<>();
            list = messageService.getRentRequestMessages(Long.parseLong(id), Long.parseLong(id2));
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/rentRequest/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAuthority('ROLE_AGENT') or hasAuthority('ROLE_CLIENT')")
    public List<MessageDTO> getMessagesFromRentRequest(@PathVariable("id") String id) {

        try {
            List<MessageDTO> list = new ArrayList<>();
            list = messageService.getRentRequestMessagesById(Long.parseLong(id));
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    //@Secured("ROLE_ADMIN")
    public ResponseEntity<?> newMessage(@RequestBody MessageDTO messageDTO) {

        try {

            Message newMessage = this.messageService.save(messageDTO);
            return new ResponseEntity<>(newMessage, HttpStatus.OK);

        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
