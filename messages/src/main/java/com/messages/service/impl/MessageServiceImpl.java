package com.messages.service.impl;

import com.messages.client.AuthenticationClient;
import com.messages.dto.MessageDTO;
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
            listaDTO.add(new MessageDTO(m.getId(), m.getDate(), m.getContent(), m.getSenderId(), sender.getUsername(), m.getRecepientId(), m.getRentRequest().getId()));
        }
        return listaDTO;
    }

    @Override
    public void save(MessageDTO messageDTO) {
        Message newMessage = new Message();
        newMessage.setContent(messageDTO.getContent());
        newMessage.setRentRequestId(messageDTO.getRentRequestId());
        newMessage.setDate(LocalDateTime.now());
        newMessage.setSeen(false);
        newMessage.setSenderId(messageDTO.getSenderId());
        if (messageDTO.getSenderId() == rentRequest.getSender().getId()) {
            newMessage.setRecepient(rentRequest.getAdvertisement().getOwner());
        } else {
            newMessage.setRecepient(rentRequest.getSender());
        }
        this.messageRepository.save(newMessage);
    }
}
