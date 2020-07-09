package com.advertisement.soap;

import com.advertisement.model.Term;
import com.advertisement.service.TermService;
import com.advertisement.soap.code.AdvertisementDTO;
import com.advertisement.soap.code.GetAllAgentsRentedTermsRequest;
import com.advertisement.soap.code.GetAllAgentsRentedTermsResponse;
import com.advertisement.soap.code.TermDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class ReportEndPoint {

    @Autowired
    private TermService termService;

    private static final String NAMESPACE_URI = "http://localhost:8084/advertisement";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAgentsRented")
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
            advertisementDTO.setId(t.getAdvertisement().getId());
            advertisementDTO.setName(t.getAdvertisement().getCar().getName());
            advertisementDTO.setCarBrand(t.getAdvertisement().getCar().getCarBrand().getName());
            advertisementDTO.setModel(t.getAdvertisement().getCar().getCarModel().getName());
            advertisementDTO.setStartDate(t.getAdvertisement().getStartDate().toString());
            advertisementDTO.setEndDate(t.getAdvertisement().getEndDate().toString());

            termDTO.setAdvertisement(advertisementDTO);

            response.getTermDTOS().add(termDTO);

        }

        System.out.println("POYYYY");
        return response;

    }

}
