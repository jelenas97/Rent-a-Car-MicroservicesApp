package com.rent.dto;

import com.rent.adapter.LocalDateAdapter;
import com.rent.model.RentRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RentRequest", namespace = "http://localhost:8095/rent")
@XmlRootElement(name = "rentRequestClass")
public class RentRequestDTO {

    @XmlElement
    private Long id;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @XmlElement
    private LocalDateTime startDateTime;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @XmlElement
    private LocalDateTime endDateTime;
    @XmlElement
    private String startDateString;
    @XmlElement
    private String endDateString;
    @XmlElement
    private String rentRequestStatus;
    @XmlElement
    private String cars;
    @XmlElement
    private Long advertisementId;
    @XmlElement
    private Long senderId;
    @XmlElement
    private int numberOfUnseen;


    public RentRequestDTO(RentRequest rr, int numberOfUnseen) {

        this.id = rr.getId();
        String[] dateTime = rr.getStartDateTime().toString().split("T");
        this.startDateString = dateTime[0] + " at " + dateTime[1] + "h";
        this.startDateTime = rr.getStartDateTime();
        String[] dateTime1 = rr.getEndDateTime().toString().split("T");
        this.endDateString = dateTime1[0] + " at " + dateTime1[1] + "h";
        this.endDateTime = rr.getEndDateTime();
        this.rentRequestStatus = rr.getRentRequestStatus().toString();

        //this.cars = rr.getAdvertisement().getCar().getCarClass().toString();
        this.advertisementId = rr.getAdvertisementId();
        this.senderId = rr.getSenderId();
        this.numberOfUnseen = numberOfUnseen;

    }

    public RentRequestDTO(RentRequest rr) {

        this.id = rr.getId();
        String[] dateTime = rr.getStartDateTime().toString().split("T");
        this.startDateString = dateTime[0] + " at " + dateTime[1] + "h";
        this.startDateTime = rr.getStartDateTime();
        String[] dateTime1 = rr.getEndDateTime().toString().split("T");
        this.endDateString = dateTime1[0] + " at " + dateTime1[1] + "h";
        this.endDateTime = rr.getEndDateTime();
        this.rentRequestStatus = rr.getRentRequestStatus().toString();
        // this.cars = rr.getAdvertisement().getCar().getCarClass().toString();
        this.advertisementId = rr.getAdvertisementId();
        this.senderId = rr.getSenderId();

    }

    @Override
    public String toString() {
        return "RentRequestDTO{" +
                "id=" + id +
                ", startDateTime='" + startDateTime + '\'' +
                ", endDateTime='" + endDateTime + '\'' +
                ", rentRequestStatus='" + rentRequestStatus + '\'' +
                ", cars='" + cars + '\'' +
                ", advertisementId=" + advertisementId +
                ", senderId=" + senderId +
                '}';
    }

}
