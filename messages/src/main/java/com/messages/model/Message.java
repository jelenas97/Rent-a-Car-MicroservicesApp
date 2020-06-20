package com.messages.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.messages.adapter.LocalDateAdapter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Messages", namespace = "http://localhost:8087/microservices/messages")
@XmlRootElement(name = "messageClass")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement
    private Long id;

    @Column
    @XmlElement
    public Long rentRequestId;

    @Column
    @XmlElement
    private String content;

    @Column
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @XmlElement
    private LocalDateTime date;

    @Column
    @XmlElement
    public Long senderId;

    @Column
    @XmlElement
    public Long recepientId;
    @Column
    @XmlElement
    private Boolean seen;
}
