package com.rent.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDTO {
    private Long id;
    private String dateString;
    private String content;
    private Long senderId;
    private String senderUsername;
    private Long recepientId;
    private Long rentRequestId;
    private boolean seen;

}
