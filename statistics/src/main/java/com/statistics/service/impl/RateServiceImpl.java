package com.statistics.service.impl;

import com.statistics.client.AuthenticationClient;
import com.statistics.dto.RateDTO;
import com.statistics.dto.UserDTO;
import com.statistics.model.Rate;
import com.statistics.repository.RateRepository;
import com.statistics.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    RateRepository rateRepository;

    @Autowired
    AuthenticationClient authenticationClient;

    @Override
    public long rateAdvertisement(RateDTO dto) {

        Rate rate = new Rate();
        rate.setValue(dto.getValue());
        rate.setAdvertisementId(dto.getAdvertisement_id());
        rate.setClientId(dto.getClient_id());
        rate.setRentRequestId(dto.getRent_request_id());
        Rate r = this.rateRepository.save(rate);

        return r.getId();
    }

    @Override
    public List<RateDTO> findAverageAdvRate(long id){

        List<Rate> rates = this.rateRepository.findByAdvertisementId(id);
        List<RateDTO> rateDTOS = new ArrayList<>();
        long i=0;
        long sum=0;
        float average=0;
        for(Rate rate : rates){
            i++;
            sum+=rate.getValue();
        }

        average= (float)sum/(float)i;
        for(Rate rate: rates){
            UserDTO dto = this.authenticationClient.getUser(String.valueOf(rate.getClientId()));
            rateDTOS.add(new RateDTO(rate, average, i, dto));
        }

        return rateDTOS;
    }

}
