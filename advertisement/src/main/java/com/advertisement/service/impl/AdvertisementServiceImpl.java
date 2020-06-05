package com.advertisement.service.impl;


import com.advertisement.model.Advertisement;
import com.advertisement.repository.AdvertisementRepository;
import com.advertisement.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Advertisement> findAll() {
        LocalDate today = LocalDate.now();
        List<Advertisement> ads = this.advertisementRepository.findAll(today);
        ads = loadImages(ads);
        return ads;
    }

    @Override
    public void add(Advertisement ad) {
        this.advertisementRepository.save(ad);
    }

    @Override
    public int findAllCount(Long id) {
        return this.advertisementRepository.findAllCount(id);
    }


    private List<Advertisement> loadImages(List<Advertisement> ads) {
        for (int i = 0; i < ads.size(); i++) {
            String rootPath = System.getProperty("user.dir");
            String resourceFile = rootPath + "\\advertisement\\images\\" + ads.get(i).getCar().getId() + ".txt";
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
