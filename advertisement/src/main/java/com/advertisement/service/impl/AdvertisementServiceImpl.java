package com.advertisement.service.impl;


import com.advertisement.client.AuthenticationClient;
import com.advertisement.client.StatisticClient;
import com.advertisement.dto.*;
import com.advertisement.model.*;
import com.advertisement.repository.AdvertisementRepository;
import com.advertisement.model.Advertisement;
import com.advertisement.repository.AdvertisementRepository;
import com.advertisement.repository.CarRepository;
import com.advertisement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.util.List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private CarModelService carModelService;

    @Autowired
    private FuelTypeService fuelTypeService;

    @Autowired
    private AuthenticationClient authenticationClient;

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private StatisticClient statisticClient;

    @Autowired
    private ReportService reportService;

    @Override
    public List<Advertisement> findAll() {
        LocalDate today = LocalDate.now();
        List<Advertisement> ads = this.advertisementRepository.findAll(today);
        ads = loadImages(ads);
        return ads;
    }

    @Override
    public List<Advertisement> findAll(Long agentID) {
        LocalDate today = LocalDate.now();
        return this.advertisementRepository.findAll(today, agentID);
    }

    @Override
    public List<Advertisement> search(SearchDTO dto) {

        List<Advertisement> freeAds = this.advertisementRepository.findFree(dto.getPlace(), dto.getStartDate(), dto.getEndDate());

        CarModel carModel = this.carModelService.findOneByName(dto.getCarModel());
        FuelType fuelType = this.fuelTypeService.findOneByName(dto.getFuelType());

        List<Predicate<Advertisement>> predicates = new ArrayList<>();

        if (dto.getLimitMileage() != null) {
            Predicate<Advertisement> byLimitMileage = ad -> ad.getKilometresLimit() >= dto.getLimitMileage();
            predicates.add(byLimitMileage);
        }
      /*  if (dto.getDmg() != null) {
            Predicate<Advertisement> byCwd = ad -> ad.getCdw() == dto.getDmg();
            predicates.add(byCwd);
        }*/
        if (dto.getBrand() != null) {
            Predicate<Advertisement> byBrand = ad -> ad.getCar().getCarBrand().getName().equals(dto.getBrand());
            predicates.add(byBrand);
        }
        if (dto.getFuelType() != null) {
            Predicate<Advertisement> byFuel = ad -> ad.getCar().getFuelType().contains(fuelType);
            predicates.add(byFuel);
        }
        if (dto.getCarClass() != null) {
            Predicate<Advertisement> byClass = ad -> ad.getCar().getCarClass().getName().equals(dto.getCarClass());
            predicates.add(byClass);
        }
        if (dto.getTransmissionType() != null) {
            Predicate<Advertisement> byTrans = ad -> ad.getCar().getTransmissionType().getName().equals(dto.getTransmissionType());
            predicates.add(byTrans);
        }
        if (dto.getSeats() != null) {
            Predicate<Advertisement> byKidSeats = ad -> ad.getCar().getKidSeats().equals(dto.getSeats());
            predicates.add(byKidSeats);
        }
        if (dto.getMileage() != null) {
            Predicate<Advertisement> byMileage = ad -> ad.getCar().getMileage().equals(dto.getMileage());
            predicates.add(byMileage);
        }
        if (dto.getMaxPrice() != null) {
            Predicate<Advertisement> byMaxPrice = ad -> ad.getPriceList().getPricePerDay() <= dto.getMaxPrice();
            predicates.add(byMaxPrice);
        }
        if (dto.getMinPrice() != null) {
            Predicate<Advertisement> byMinPrice = ad -> ad.getPriceList().getPricePerDay() >= dto.getMinPrice();
            predicates.add(byMinPrice);
        }

        for (Predicate<Advertisement> predicate : predicates) {
            List<Advertisement> result = freeAds.stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
            freeAds = result;
        }

        List<Advertisement> retAds = new ArrayList<>();
        for (Advertisement adv : freeAds) {
            if (carModel != null) {
                if (adv.getCar().getCarBrand().getCarModels().contains(carModel)) {
                    retAds.add(adv);
                }
            } else {
                retAds.add(adv);
            }
        }
        retAds = loadImages(retAds);
        return retAds;
    }
    @Override
    public Advertisement find(Long id) {
        System.out.println("Pokusavam da pronadjem id" + id);
        return this.advertisementRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<?> add(Advertisement ad) {
        try {
//            UserDTO userDTO = this.authenticationClient.getUser(ad.getOwnerId().toString());
//            if (userDTO.getRoles().get(0).equals("ROLE_CLIENT")) {
//                int numberOfAds = this.findAllCount(ad.getOwnerId());
//                if (numberOfAds >= 3) {
//                    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("You can not create more than 3 advertisement");
//                }
//            }
            this.carService.add(ad.getCar());
            ad.setDiscount(0);
            ad.setTerms(new HashSet<>());
            this.advertisementRepository.save(ad);

            return new ResponseEntity(ad,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public int findAllCount(Long id) {
        return this.advertisementRepository.findAllCount(id);
    }


    private List<Advertisement> loadImages(List<Advertisement> ads) {
        for (int i = 0; i < ads.size(); i++) {
            String resourceFile = "images/" + ads.get(i).getCar().getId() + ".txt";
            ads.get(i).getCar().setImageGallery(new ArrayList<String>());

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(resourceFile))) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    ads.get(i).getCar().getImageGallery().add(line);
                    line = bufferedReader.readLine();
                }
            } catch (FileNotFoundException e) {
                // Exception handling
            } catch (IOException e) {
                // Exception handling
            }
        }
        return ads;
    }

    @Override
    public String getRentRequestsCarClass(Long id) {

        Advertisement a= this.advertisementRepository.find(id);
        String carClass=a.getCar().getCarClass().getName();

        return carClass;
    }

    @Override
    public List<StatisticDTO> getMostComment(Long id) {
        List<StatisticDTO> statistics = new ArrayList<StatisticDTO>();
        List<Advertisement> ads = this.findAll(id);
        for (Advertisement a : ads) {
            StatisticDTO stat = new StatisticDTO();
            ResponseEntity<List<CommentDTO>> commentsRE = this.statisticClient.getProcessedAdvertisementComments(a.getId());
            Long numberOfComments = Integer.toUnsignedLong(commentsRE.getBody().size());
            Long idCar = this.advertisementRepository.getCarId(a.getId());
            Car car = this.carRepository.findById(idCar).orElse(null);
            stat.setCarName(car.getName());
            stat.setComment(numberOfComments);
            statistics.add(stat);
        }
        statistics.sort(Comparator.comparing(StatisticDTO::getComment).reversed());
        return statistics;
    }

    @Override
    public List<StatisticDTO> getMostKm(Long id) {
        List<StatisticDTO> statistics = new ArrayList<StatisticDTO>();
        List<Advertisement> ads = this.findAll(id);
        for (Advertisement a : ads) {
            Long idCar = this.advertisementRepository.getCarId(a.getId());
            Car car = this.carRepository.findById(idCar).orElse(null);
            StatisticDTO stat = new StatisticDTO();
            stat.setCarName(car.getName());
            Long km = 0l;
            List<Report> reports =  this.reportService.findAllByAd(a.getId());
            for(Report r : reports)
            {
                km += r.getKilometers();
            }
            stat.setKm(km);
            statistics.add(stat);
        }
        statistics.sort(Comparator.comparing(StatisticDTO::getKm).reversed());
        return statistics;
    }

    @Override
    public List<StatisticDTO> getBestRate(Long id) {
        List<StatisticDTO> statisticDTOList = new ArrayList<StatisticDTO>();
        List<Advertisement> ads = this.findAll(id);
        for(Advertisement ad : ads)
        {
            double rate = 0.0;
            RateDTO rates = this.statisticClient.getAverageAdvertisementRateFirst(ad.getId());
            if(rates != null) {
                rate = rates.getAverage_rate();
            }
            StatisticDTO statisticDTO = new StatisticDTO();
            CarDTO car = this.carService.findById(this.getIdCar(ad.getId()));
            statisticDTO.setCarName(car.getCarBrand() + ' ' + car.getCarModel());
            statisticDTO.setRate(rate);
            statisticDTOList.add(statisticDTO);
        }
        statisticDTOList.sort(Comparator.comparing(StatisticDTO::getRate).reversed());
        return statisticDTOList;
    }

    @Override
    public String getIdCar(Long id) {
        Long idCar = this.advertisementRepository.getCarId(id);
        return idCar.toString();
    }

    private List<Advertisement> loadImagesLocally(List<Advertisement> ads) {
        for (int i = 0; i < ads.size(); i++) {
            String rootPath = System.getProperty("user.dir");
            String resourceFile = rootPath + "\\advertisement\\images\\" +  ads.get(i).getCar().getId() + ".txt";
            ads.get(i).getCar().setImageGallery(new ArrayList<String>());

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(resourceFile))) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    ads.get(i).getCar().getImageGallery().add(line);
                    line = bufferedReader.readLine();
                }
            } catch (FileNotFoundException e) {
                // Exception handling
            } catch (IOException e) {
                // Exception handling
            }
        }
        return ads;
    }
}
