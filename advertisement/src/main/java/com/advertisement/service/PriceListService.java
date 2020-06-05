package com.advertisement.service;

import com.advertisement.dto.PriceListDTO;
import com.advertisement.model.PriceList;

import java.util.List;

public interface PriceListService {

    PriceList createNewPriceList(PriceListDTO dto);

    List<PriceListDTO> getCreatorsPriceLists(Long id);
}
