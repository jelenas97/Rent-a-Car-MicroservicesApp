package com.messages.controller;

import com.messages.dto.MessageDTO;
import com.messages.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "message")
@CrossOrigin("http://localhost:4200")
public class MessageController {

    @Autowired
    private MessageService messageService;

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

    @PostMapping(produces = "application/json", consumes = "application/json")
    //@Secured("ROLE_ADMIN")
    public ResponseEntity<?> newMessage(@RequestBody MessageDTO messageDTO) {

        try {
            this.messageService.save(messageDTO);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
