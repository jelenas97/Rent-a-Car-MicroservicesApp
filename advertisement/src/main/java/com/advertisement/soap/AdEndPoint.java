package com.advertisement.soap;

import com.advertisement.client.AuthenticationClient;
import com.advertisement.model.Advertisement;
import com.advertisement.model.Car;
import com.advertisement.model.PriceList;
import com.advertisement.service.*;
import com.advertisement.soap.code.PostAdRequest;
import com.advertisement.soap.code.PostAdResponse;
import com.netflix.discovery.converters.jackson.serializer.ApplicationXmlDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import java.beans.XMLDecoder;
import java.time.LocalDate;

@Endpoint
public class AdEndPoint {
    private static final String NAMESPACE_URI = "http://localhost:8084/advertisement";

    @Autowired
    private AdvertisementService adService;

    @Autowired
    private AuthenticationClient authenticationClient;

    @Autowired
    private CarBrandService carBrandService;

    @Autowired
    private CarModelService carModelService;

    @Autowired
    private CarClassService carClassService;

    @Autowired
    private FuelTypeService fuelTypeService;

    @Autowired
    private TransmissionTypeService transTypeService;

    @Autowired
    private PriceListService priceListService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postAdRequest")
    @ResponsePayload
    public PostAdResponse getTest(@RequestPayload PostAdRequest request) {
        System.out.println("Soap request");
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        CustomPrincipal cp = (CustomPrincipal) auth.getPrincipal();

        PostAdResponse response = new PostAdResponse();
        Advertisement newAd = new Advertisement();
        LocalDate startDate = LocalDate.parse(request.getStartDate());
        //Instant.ofEpochMilli(request.getStartDate().getMillisecond()).atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate endDate = LocalDate.parse(request.getEndDate());
        // Instant.ofEpochMilli(request.getEndDate().getMillisecond()).atZone(ZoneId.systemDefault()).toLocalDate();

        newAd.setOwnerId(request.getOwnerId());
        newAd.setStartDate(startDate);
        newAd.setEndDate(endDate);
        newAd.setCdw(request.isCdw());
        newAd.setKilometresLimit(request.getLimitKm());
        newAd.setPlace(request.getLocation());
//treba discount

        Car newCar = new Car();
        newCar.setAvailableTracking(request.getCar().isAvailableTracking());
        newCar.setCarBrand(carBrandService.findOne(request.getCar().getCarBrand().getId()));
        newCar.setCarClass(carClassService.findOne(request.getCar().getCarClass().getId()));
        newCar.setCarModel(carModelService.findOne(request.getCar().getCarModel().getId()));
        newCar.getFuelType().add(fuelTypeService.findOne(request.getCar().getFuelType().get(0).getId()));
        newCar.setImageGallery(request.getCar().getImageGallery());
        newCar.setKidSeats(request.getCar().getKidSeats());
        newCar.setMileage(request.getCar().getMileage());
        newCar.setRate(request.getCar().getRate());
        newCar.setTransmissionType(transTypeService.findOne(request.getCar().getTransmissionType().getId()));
        newAd.setCar(newCar);

        PriceList priceList = priceListService.findById(request.getPriceList().getId());
        newAd.setPriceList(priceList);

        ResponseEntity responseEntity = adService.add(newAd);
        Advertisement postedAd = (Advertisement) responseEntity.getBody();

        response.setIdAd(postedAd.getId());
        response.setIdCar(postedAd.getCar().getId());
        response.setIdPriceList(postedAd.getPriceList().getId());

        System.out.println("zavrsio request");
        return response;

}

}
