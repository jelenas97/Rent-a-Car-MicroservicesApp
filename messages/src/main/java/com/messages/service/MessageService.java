package com.messages.service;

import com.messages.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    List<MessageDTO> getRentRequestMessages(long id, long userId);

    void save(MessageDTO messageDTO);

}
