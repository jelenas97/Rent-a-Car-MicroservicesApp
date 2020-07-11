package com.rent.dto;

import com.rent.model.RentRequest;
import com.rent.model.RequestsHolder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestsHolderDTO {
    @XmlElement
    private Long id;
    @XmlElement
    private Boolean bundle;
    @XmlElement
    private Set<RentRequestDTO> rentRequests;

    public RequestsHolderDTO(RequestsHolder requestsHolder) {
        this.id = requestsHolder.getId();
        this.bundle = requestsHolder.getBundle();
        this.rentRequests = new HashSet<>();
        for (RentRequest req : requestsHolder.getRentRequests()) {
            this.rentRequests.add(new RentRequestDTO(req));
        }
    }

    @Override
    public String toString() {
        return "RequestsHolderDTO{" +
                "id=" + id +
                ", bundle=" + bundle +
                ", rentRequests=" + rentRequests +
                '}';
    }
}
