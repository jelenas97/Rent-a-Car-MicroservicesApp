package com.messages.service.impl;

import com.messages.client.AdvertisementClient;
import com.messages.client.AuthenticationClient;
import com.messages.client.RentClient;
import com.messages.dto.AdvertisementDTO;
import com.messages.dto.MessageDTO;
import com.messages.dto.RentRequestDTO;
import com.messages.dto.UserDTO;
import com.messages.model.Message;
import com.messages.repository.MessageRepository;
import com.messages.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private AuthenticationClient authenticationClient;

    @Autowired
    private RentClient rentClient;

    @Autowired
    private AdvertisementClient advertisementClient;

    @Override
    public List<MessageDTO> getRentRequestMessages(long id, long userId) {
        List<Message> lista = this.messageRepository.getRentRequestMessages(id);
        List<MessageDTO> listaDTO = new ArrayList<MessageDTO>();
        for (Message m : lista) {
            if (m.getRecepientId() == userId) {
                if (m.getSeen().equals(false)) {
                    m.setSeen(true);
                    this.messageRepository.save(m);
                }
            }
            UserDTO sender = authenticationClient.getUser(m.getSenderId().toString());
            listaDTO.add(new MessageDTO(m.getId(), m.getDate(), m.getContent(), m.getSenderId(), sender.getUsername(), m.getRecepientId(), m.getRentRequestId(),m.getSeen()));
        }
        return listaDTO;
    }

    @Override
    public Message save(MessageDTO messageDTO) {
        Message newMessage = new Message();
        newMessage.setContent(messageDTO.getContent());
        newMessage.setRentRequestId(messageDTO.getRentRequestId());
        newMessage.setDate(LocalDateTime.now());
        newMessage.setSeen(false);
        newMessage.setSenderId(messageDTO.getSenderId());
        Long id = messageDTO.getRentRequestId();
        RentRequestDTO rentRequest = rentClient.getRentRequest(id.toString());
        AdvertisementDTO advertisementDTO = advertisementClient.getAdvertisement(rentRequest.getAdvertisementId());
        if (messageDTO.getSenderId() == rentRequest.getSenderId()) {
            newMessage.setRecepientId(advertisementDTO.getOwnerID());
        } else {
            newMessage.setRecepientId(rentRequest.getSenderId());
        }
        newMessage = this.messageRepository.save(newMessage);
        return newMessage;
    }

    @Override
    public List<MessageDTO> getRentRequestMessagesById(long id) {
        List<Message> lista = this.messageRepository.getRentRequestMessages(id);
        List<MessageDTO> listaDTO = new ArrayList<MessageDTO>();
        for (Message m : lista) {
            UserDTO sender = authenticationClient.getUser(m.getSenderId().toString());
            listaDTO.add(new MessageDTO(m.getId(), m.getDate(), m.getContent(), m.getSenderId(), sender.getUsername(), m.getRecepientId(), m.getRentRequestId(),m.getSeen()));
        }
        return listaDTO;    }
}
