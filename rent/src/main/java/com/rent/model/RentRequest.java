package com.rent.model;


import com.rent.dto.RentRequestDTO;
import com.rent.enumerations.RentRequestStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RentRequest implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Column(name = "startDateTime", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "endDateTime", nullable = false)
    private LocalDateTime endDateTime;

    @Enumerated(EnumType.STRING)
    private RentRequestStatus rentRequestStatus;

    @Column
    private Long senderId;

    @Column(nullable = false)
    private Long advertisementId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private RequestsHolder requests;

    @Column
    private LocalDateTime created = LocalDateTime.now();


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
