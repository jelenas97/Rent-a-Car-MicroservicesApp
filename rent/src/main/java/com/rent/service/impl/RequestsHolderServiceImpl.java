package com.rent.service.impl;

import com.rent.client.AdvertisementClient;
import com.rent.dto.AdvertisementDTO;
import com.rent.dto.RequestsHolderDTO;
import com.rent.model.RentRequest;
import com.rent.model.RequestsHolder;
import com.rent.repository.RequestsHolderRepository;
import com.rent.service.RequestsHolderService;
import com.rent.soap.code.RentRequestStatus;
import com.rent.soap.code.RentRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//import com.rent.soap.code.RentRequestStatus;
//import com.rent.soap.code.RentRequests;

@Service
public class RequestsHolderServiceImpl implements RequestsHolderService {

    @Autowired
    private RequestsHolderRepository requestsHolderRepository;

    @Autowired
    private AdvertisementClient advertisementClient;

    @Override
    public void save(RequestsHolder requestsHolder) {
        this.requestsHolderRepository.save(requestsHolder);
    }

    @Override
    public List<RequestsHolderDTO> getAllPending(Long id) {

        List<AdvertisementDTO> advertisements = this.advertisementClient.getUserAdvertisements(id);
        List<Long> ads = new ArrayList<>();
        for (AdvertisementDTO ad : advertisements) {
            ads.add(ad.getId());
        }
        List<RequestsHolder> holders = this.requestsHolderRepository.getAllPending(ads);
        List<RequestsHolderDTO> requestsHolderDTOS = new ArrayList<>();

//        List<Long> adsIds = advertisementDTOS.stream()
//                .map(AdvertisementDTO::getId)
//                .collect(Collectors.toList());

        for (RequestsHolder req : holders) {
            requestsHolderDTOS.add(new RequestsHolderDTO(req));
        }
        return requestsHolderDTOS;
    }

    @Override
    public List<com.rent.soap.code.RequestsHolder> getAllPendingSoap(Long id) {

        List<AdvertisementDTO> advertisements = this.advertisementClient.getUserAdvertisements(id);
        List<Long> ads = new ArrayList<>();
        for (AdvertisementDTO ad : advertisements) {
            ads.add(ad.getId());
        }
        List<RequestsHolder> holders = this.requestsHolderRepository.getAllPending(ads);
        List<com.rent.soap.code.RequestsHolder> holdersSoap = new ArrayList<>();

        for (RequestsHolder holder : holders) {
            com.rent.soap.code.RequestsHolder newH = new com.rent.soap.code.RequestsHolder();

            newH.setId(holder.getId());
            newH.setBundle(holder.getBundle());
            for (RentRequest rent : holder.getRentRequests()) {
                RentRequests soapReq = new RentRequests();
                soapReq.setId(rent.getId());
                soapReq.setVersion(rent.getVersion());
                soapReq.setEndDateTime(rent.getEndDateTime().toString());
                soapReq.setStartDateTime(rent.getStartDateTime().toString());
                com.rent.enumerations.RentRequestStatus rentRequestStatus = rent.getRentRequestStatus();
                RentRequestStatus statusSoap = RentRequestStatus.valueOf(rentRequestStatus.toString());
                soapReq.setRentRequestStatus(statusSoap);
                soapReq.setSenderId(rent.getSenderId());
                soapReq.setAdvertisementId(rent.getAdvertisementId());
                soapReq.setCreated(rent.getCreated().toString());
                soapReq.setRequests(newH);

                newH.getRentRequests().add(soapReq);
            }

            holdersSoap.add(newH);
        }


        return holdersSoap;
    }

    @Override
    public RequestsHolder findById(Long id) {
        return this.requestsHolderRepository.find(id);
    }
}