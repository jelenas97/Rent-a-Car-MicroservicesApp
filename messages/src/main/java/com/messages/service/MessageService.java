package com.messages.service;

import com.messages.dto.MessageDTO;
import com.messages.model.Message;

import java.util.List;

public interface MessageService {
    List<MessageDTO> getRentRequestMessages(long id, long userId);

    Message save(MessageDTO messageDTO);

    List<MessageDTO> getRentRequestMessagesById(long id);
}
