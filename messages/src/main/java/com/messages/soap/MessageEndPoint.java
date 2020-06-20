package com.messages.soap;

import com.messages.dto.MessageDTO;
import com.messages.model.Message;
import com.messages.service.MessageService;
import com.messages.soap.code.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Endpoint
public class MessageEndPoint {
    private static final String NAMESPACE_URI = "http://localhost:8087/microservices/messages";

    @Autowired
    private MessageService messageService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postMessageRequest")
    @ResponsePayload
    public PostMessageResponse saveMessageSoap(@RequestPayload PostMessageRequest message) {
        System.out.println("Soap request");
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        CustomPrincipal cp = (CustomPrincipal) auth.getPrincipal();

        MessageDTO newMessage = new MessageDTO();
        Messages messageSoap = message.getMessage();
        newMessage.setSenderId(messageSoap.getSenderId());
        newMessage.setRentRequestId(messageSoap.getRentRequestId());
        newMessage.setContent(messageSoap.getContent());

        Message messageResponse = messageService.save(newMessage);
        PostMessageResponse messageResponseSoap = new PostMessageResponse();
        messageResponseSoap.setIdMessage(messageResponse.getId());

        return messageResponseSoap;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMessageRequest")
    @ResponsePayload
    public GetMessageResponse getMessage(@RequestPayload GetMessageRequest message) {
        System.out.println("Soap request");
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        CustomPrincipal cp = (CustomPrincipal) auth.getPrincipal();

        List<MessageDTO> messages = messageService.getRentRequestMessages(message.getRentRequestId(), message.getUserId());
        GetMessageResponse response = new GetMessageResponse();

        for(MessageDTO messageDTO : messages) {
            Messages soapMessage = new Messages();
            soapMessage.setId(messageDTO.getId());
            soapMessage.setContent(messageDTO.getContent());
            soapMessage.setDate(messageDTO.getDateString());
            soapMessage.setRecepientId(messageDTO.getRecepientId());
            soapMessage.setRentRequestId(messageDTO.getRentRequestId());
            soapMessage.setSeen(messageDTO.isSeen());
            soapMessage.setSenderId(messageDTO.getSenderId());
            response.getMessage().add(soapMessage);
        }

        return response;

    }

}
