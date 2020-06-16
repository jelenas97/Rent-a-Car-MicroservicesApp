package com.advertisement.soap;

import com.advertisement.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
public class AdEndPoint {
    private static final String NAMESPACE_URI = "http://www.rent-a-car.com/ad-service/soap";

    @Autowired
    private AdvertisementService adService;

//    @Autowired
//    private UserClient userClient;

//    @Autowired
//    private PriceListServiceImpl priceListService;
//
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postAdRequest")
//    @ResponsePayload
//    public PostAdResponse getTest(@RequestPayload PostAdRequest request) {
//        System.out.println("Soap request");
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        CustomPrincipal cp = (CustomPrincipal) auth.getPrincipal();
//
//        PostAdResponse response = new PostAdResponse();
//        System.out.println("0");
//        AdDTO newAdDTO = new AdDTO();
//        LocalDate startDate = LocalDate.parse(request.getStartDate());
//        //Instant.ofEpochMilli(request.getStartDate().getMillisecond()).atZone(ZoneId.systemDefault()).toLocalDate();
//
//        LocalDate endDate = LocalDate.parse(request.getEndDate());
//        // Instant.ofEpochMilli(request.getEndDate().getMillisecond()).atZone(ZoneId.systemDefault()).toLocalDate();
//
//        newAdDTO.setOwnerId(request.getOwnerId());
//        newAdDTO.setStartDate(startDate);
//        newAdDTO.setEndDate(endDate);
//        newAdDTO.setCdw(request.isCdw());
//        newAdDTO.setLimitKm(request.getLimitKm());
//        newAdDTO.setLocation(request.getLocation());
//        newAdDTO.setLimitKm(request.getLimitKm());
//        System.out.println("1");
//        //ako je == 0 onda znaci da taj price list ne postoji pa cemo ga dodati
//        //ovo je samo ako se recimo novi agent zakaci pa ima vec odredjen broj price listova kod sebe koji nisu dodati na glavnom
//        if(request.getPriceList().getId() != 0) {
//            System.out.println("Postoji price");
//            PriceListDTO priceListDTO = new PriceListDTO();
//            priceListDTO.setId(request.getPriceList().getId());
//            newAdDTO.setPriceList(priceListDTO); //postavi id od pricelista samo je to vazno jer je price list vec dodat
//
//        }else{
//            //dodaj price list
//            System.out.println("Novi price");
//            com.team19.admicroservice.model.PriceList priceList = new PriceList();
//            priceList.setAlias(request.getPriceList().getAlias());
//            priceList.setDiscount20Days(request.getPriceList().getDiscount20Days());
//            priceList.setDiscount30Days(request.getPriceList().getDiscount30Days());
//            priceList.setPricePerDay(request.getPriceList().getPricePerDay());
//            priceList.setPricePerKm(request.getPriceList().getPricePerKm());
//            priceList.setOwnerId(Long.parseLong(cp.getUserID()));
//            priceList = priceListService.save(priceList);
//
//            PriceListDTO priceListDTO = new PriceListDTO();
//            priceListDTO.setId(priceList.getId());
//
//
//
//
//
//            newAdDTO.setPriceList(priceListDTO); //postavi id od pricelista samo je to vazno jer je price list vec dodat
//
//        }
//        System.out.println("2");
//        CarDTO carDTO = new CarDTO();
//
//        if(request.getCar().getId() !=0)
//            carDTO.setId(request.getCar().getId());
//        System.out.println("3");
//        carDTO.setCarModel(request.getCar().getCarModel().replace("_"," "));
//        carDTO.setCarBrand(request.getCar().getCarBrand().replace("_"," "));
//        carDTO.setCarClass(request.getCar().getCarClass().replace("_"," "));
//        carDTO.setChildrenSeats(request.getCar().getChildrenSeats());
//        carDTO.setFuelType(request.getCar().getFeulType().replace("_"," "));
//        carDTO.setHasAndroidApp(request.getCar().isHasAndroidApp());
//        carDTO.setMileage(request.getCar().getMileage());
//        carDTO.setTransType(request.getCar().getTransType().replace("_"," "));
//        carDTO.setPhotos64(new ArrayList<>());
//        for(String img: request.getCar().getPhotos64()){
//            System.out.println("Slika: "+img);
//            carDTO.getPhotos64().add(img);
//        }
//
//        newAdDTO.setCar(carDTO);
//        System.out.println("Postavlja request");
//        AdDTO postedAd = adService.postNewAd(newAdDTO);
//
//        response.setIdAd(postedAd.getId());
//        response.setIdCar(postedAd.getCar().getId());
//        response.setIdPriceList(postedAd.getPriceList().getId());
//
//        System.out.println("zavrsio request");
//        return response;

//}

}