package com.advertisement.service.impl;

import com.advertisement.dto.PriceListDTO;
import com.advertisement.model.PriceList;
import com.advertisement.repository.PriceListRepository;
import com.advertisement.service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceListServiceImpl implements PriceListService {

    @Autowired
    private PriceListRepository priceListRepository;

    @Override
    public PriceList createNewPriceList(PriceListDTO dto) {


        PriceList priceList = new PriceList();
        priceList.setCdw(dto.getCdw());
        priceList.setPricePerDay(dto.getPricePerDay());
        priceList.setPricePerKm(dto.getPricePerKm());
        priceList.setCreatorId(dto.getCreatorId());
        this.priceListRepository.save(priceList);

        return priceList;
    }

    @Override
    public List<PriceListDTO> getCreatorsPriceLists(Long id) {
        List<PriceListDTO> dtoList = new ArrayList<>();
        List<PriceList> list = priceListRepository.findByCreatorId(id);
        for (PriceList p : list) {
            dtoList.add(new PriceListDTO(p));
        }
        return dtoList;
    }

    @Override
    public PriceList findById(Long id) {
        return this.priceListRepository.findById(id).orElse(null);
    }
}
