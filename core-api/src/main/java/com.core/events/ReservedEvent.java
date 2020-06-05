package com.core.events;

public class ReservedEvent {

    private Long rentRequestId;
    private String status;
    private String startDate;
    private String endDate;
    private Long advertisementId;

    public ReservedEvent() {
    }

    public ReservedEvent(Long rentRequestId,
                         String status, String startDate, String endDate, Long adertisementId) {
        this.rentRequestId = rentRequestId;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.advertisementId = adertisementId;
        System.out.println("CORE API RESERVE EVENT TERM COMMAN " + this.rentRequestId + this.status);

    }

    public Long getRentRequestId() {
        return rentRequestId;
    }

    public void setRentRequestId(Long rentRequestId) {
        this.rentRequestId = rentRequestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Long advertisementId) {
        this.advertisementId = advertisementId;
    }
}
