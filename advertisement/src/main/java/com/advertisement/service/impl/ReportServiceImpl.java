package com.advertisement.service.impl;

import com.advertisement.client.RentClient;
import com.advertisement.dto.ExtraPayDTO;
import com.advertisement.model.PriceList;
import com.advertisement.model.Report;
import com.advertisement.repository.PriceListRepository;
import com.advertisement.repository.ReportRepository;
import com.advertisement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private PriceListRepository priceListRepository;

    @Autowired
    private RentClient rentClient;

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public ResponseEntity<?> save(Report report) {

        try{
            reportRepository.save(report);
            return new ResponseEntity(report,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void extraPay(Report report){

        ExtraPayDTO extraPayDTO = new ExtraPayDTO();
        extraPayDTO.setStartDate(report.getTerm().getStartDate());
        extraPayDTO.setEndDate(report.getTerm().getEndDate());
        extraPayDTO.setAdvertisementId(report.getAdvertisement().getId());

        PriceList priceList= priceListRepository.findByAdvertisementId(extraPayDTO.getAdvertisementId());
        long input = priceList.getPricePerKm().longValue();
        Long finalPrice = input * report.getKilometers();
        extraPayDTO.setExtraPayPrice(finalPrice);
        this.rentClient.addExtraPay(extraPayDTO);
    }

    @Override
    public List<Report> findAllByAd(Long id) {
        return this.reportRepository.findAllByAdId(id);
    }
}
