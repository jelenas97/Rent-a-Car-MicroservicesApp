package com.advertisement.soap;

import com.advertisement.dto.CarDTO;
import com.advertisement.model.Advertisement;
import com.advertisement.model.Report;
import com.advertisement.model.Term;
import com.advertisement.service.AdvertisementService;
import com.advertisement.service.CarService;
import com.advertisement.service.ReportService;
import com.advertisement.service.TermService;
import com.advertisement.soap.code.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class ReportEndPoint {

    @Autowired
    private CarService carService;

    @Autowired
    private TermService termService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private AdvertisementService advertisementService;


    private static final String NAMESPACE_URI = "http://localhost:8084/advertisement";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAgentsRentedTermsRequest")
    @ResponsePayload
    public GetAllAgentsRentedTermsResponse getAllAgentsRentedTerms(@RequestPayload GetAllAgentsRentedTermsRequest request) {
        System.out.println("Soap request");

        List<Term> rented = this.termService.getAllRentedFromCurrentAgent(request.getAgentId());
        GetAllAgentsRentedTermsResponse response = new GetAllAgentsRentedTermsResponse();

        for (Term t : rented) {
            TermDTO termDTO = new TermDTO();
            termDTO.setId(t.getId());
            termDTO.setStartDate(t.getStartDate().toString());
            termDTO.setEndDate(t.getEndDate().toString());

            AdvertisementDTO advertisementDTO = new AdvertisementDTO();

            Advertisement advertisement = advertisementService.find(t.getAdvertisement().getId());
            CarDTO car = carService.findById(advertisement.getCar().getId().toString());

            advertisementDTO.setId(advertisement.getId());
            advertisementDTO.setCarBrand(car.getCarBrand());
            advertisementDTO.setModel(car.getCarModel());
            advertisementDTO.setName(car.getName());

            termDTO.setAdvertisement(advertisementDTO);

            response.getTermDTOS().add(termDTO);

        }

        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postReportRequest")
    @ResponsePayload
    public PostReportResponse save(@RequestPayload PostReportRequest postReportRequest) {

        Advertisement advertisement = advertisementService.find(postReportRequest.getAdvertisementId());
        Term term = termService.findById(postReportRequest.getTermId());
        term.setReportWritten(true);
        term.setAdvertisement(advertisement);
        termService.save(term);

        PostReportResponse postReportResponse = new PostReportResponse();
        Report report = new Report();

        report.setDescription(postReportRequest.getDescription());
        report.setKilometers(postReportRequest.getKilometers());
        report.setAdvertisement(advertisement);
        report.setTerm(term);

        ResponseEntity responseEntity = reportService.save(report);
        Report postedReport = (Report) responseEntity.getBody();

        postReportResponse.setReportId(postedReport.getId());
        postReportResponse.setAdvertisementId(postedReport.getAdvertisement().getId());
        postReportResponse.setTermId(postedReport.getTerm().getId());

        return postReportResponse;
    }

}
