package com.messages.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    public Long rentRequestId;

    @Column
    private String content;
    @Column
    private LocalDateTime date;

    @Column
    public Long senderId;

    @Column
    public Long recepientId;
    @Column
    private Boolean seen;
}
