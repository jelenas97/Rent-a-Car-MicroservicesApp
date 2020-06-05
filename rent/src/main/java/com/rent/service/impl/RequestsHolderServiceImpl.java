package com.rent.service.impl;

import com.rent.client.AdvertisementClient;
import com.rent.dto.AdvertisementDTO;
import com.rent.dto.RequestsHolderDTO;
import com.rent.model.RequestsHolder;
import com.rent.repository.RequestsHolderRepository;
import com.rent.service.RequestsHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}