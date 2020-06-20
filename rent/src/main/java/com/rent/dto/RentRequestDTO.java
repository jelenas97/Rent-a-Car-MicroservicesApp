package com.rent.dto;

import com.rent.model.RentRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RentRequestDTO {

    private Long id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String startDateString;
    private String endDateString;
    private String rentRequestStatus;
    private String cars;
    private Long advertisementId;
    private Long senderId;
    private boolean rated;
    private boolean commented;
    private int numberOfUnseen;

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


    public RentRequestDTO(RentRequest rr, int numberOfUnseen, String carClass) {

        this.id = rr.getId();
        String[] dateTime = rr.getStartDateTime().toString().split("T");
        this.startDateString = dateTime[0] + " at " + dateTime[1] + "h";
        this.startDateTime = rr.getStartDateTime();
        String[] dateTime1 = rr.getEndDateTime().toString().split("T");
        this.endDateString = dateTime1[0] + " at " + dateTime1[1] + "h";
        this.endDateTime = rr.getEndDateTime();
        this.rentRequestStatus = rr.getRentRequestStatus().toString();

        this.cars = carClass;
        this.advertisementId = rr.getAdvertisementId();
        this.senderId = rr.getSenderId();
        this.numberOfUnseen = numberOfUnseen;

    }

    public RentRequestDTO(RentRequest rr, CommentAndRateDTO dto, String carClass) {

        this.id = rr.getId();
        String[] dateTime = rr.getStartDateTime().toString().split("T");
        this.startDateString = dateTime[0] + " at " + dateTime[1] + "h";
        this.startDateTime = rr.getStartDateTime();
        String[] dateTime1 = rr.getEndDateTime().toString().split("T");
        this.endDateString = dateTime1[0] + " at " + dateTime1[1] + "h";
        this.endDateTime = rr.getEndDateTime();
        this.rentRequestStatus = rr.getRentRequestStatus().toString();

        this.cars = carClass;
        this.advertisementId = rr.getAdvertisementId();
        this.senderId = rr.getSenderId();

        this.rated = true;
        if (dto.getRatedRentRequests() != null) {
            for (Long ratedRentReqId : dto.getRatedRentRequests()) {
                if (ratedRentReqId == rr.getId()) {
                    this.rated = false;
                    break;
                }
                this.rated = true;
            }
        }

        this.commented = true;
        if (dto.getCommentedRentRequests() != null) {
            for (Long commentedRentReqId : dto.getCommentedRentRequests()) {
                if (commentedRentReqId == rr.getId()) {
                    this.commented = false;
                    break;
                }
                this.commented = true;
            }
        }
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
