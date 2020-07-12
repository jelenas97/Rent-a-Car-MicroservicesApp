package com.rent.model;


import com.rent.adapter.LocalDateTimeAdapter;
import com.rent.dto.RentRequestDTO;
import com.rent.enumerations.RentRequestStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RentRequests", namespace = "http://localhost:8095/microservices/rent")
@XmlRootElement(name = "rentRequestsClass")
public class RentRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement
    private Long id;

    @Version
    @XmlElement
    private Long version;

    @Column(name = "startDateTime", nullable = false)
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    @XmlElement
    private LocalDateTime startDateTime;

    @Column(name = "endDateTime", nullable = false)
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    @XmlElement
    private LocalDateTime endDateTime;

    @Enumerated(EnumType.STRING)
    @XmlElement
    private RentRequestStatus rentRequestStatus;

    @Column
    @XmlElement
    private Long senderId;

    @Column(nullable = false)
    @XmlElement
    private Long advertisementId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @XmlElement
    private RequestsHolder requests;

    @Column
    @XmlJavaTypeAdapter(value = LocalDateTimeAdapter.class)
    @XmlElement
    private LocalDateTime created = LocalDateTime.now();

    @Column
    @XmlElement
    private Long commentId;

    @Column
    @XmlElement
    private Long rateId;

    @Column
    @XmlElement
    private Long extraPay;


    public RentRequest(RentRequestDTO requestDTO, Long senderId, Long advertisementId, RequestsHolder holder) {
        this.startDateTime = requestDTO.getStartDateTime();
        this.endDateTime = requestDTO.getEndDateTime();
        System.out.println(requestDTO.getStartDateTime());
        this.rentRequestStatus = RentRequestStatus.PENDING;
        this.senderId = senderId;
        this.advertisementId = advertisementId;
        this.requests = holder;
        this.created = LocalDateTime.now();

    }
    public RentRequest(RentRequestDTO requestDTO, Long senderId, Long advertisementId, RequestsHolder holder, RentRequestStatus status) {
        this.startDateTime = requestDTO.getStartDateTime();
        this.endDateTime = requestDTO.getEndDateTime();
        System.out.println(requestDTO.getStartDateTime());
        this.rentRequestStatus = status;
        this.senderId = senderId;
        this.advertisementId = advertisementId;
        this.requests = holder;
        this.created = LocalDateTime.now();
    }



}
