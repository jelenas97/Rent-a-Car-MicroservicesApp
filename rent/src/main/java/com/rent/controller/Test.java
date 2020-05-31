package com.rent.controller;

import com.rent.model.RentRequest;
import com.rent.repository.RentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "rent")
public class Test {

    @Autowired
    private RentRequestRepository rentRequestRepository;

    @GetMapping(path = "/test",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public List<RentRequest> getRentRequests() {
        return this.rentRequestRepository.findAll();
    }

    @GetMapping(path = "/test/config",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public List<RentRequest> save() {
        RentRequest request = new RentRequest();
        request.setStatus("NOVI");
        this.rentRequestRepository.save(request);
        return this.rentRequestRepository.findAll();
    }

    @PostMapping(value = "/request/{confirm}", produces = "application/json")
    public ResponseEntity<?> processRequest(@PathVariable String confirm) {

        try {

            if (confirm.equals("YES")) {
                RentRequest r = this.rentRequestRepository.getOne(1L);
                r.setStatus("CANCELED!!!");
                this.rentRequestRepository.save(r);

            } else {
                RentRequest r = this.rentRequestRepository.getOne(1L);
                r.setStatus("NOVI");
                this.rentRequestRepository.save(r);

            }

            return new ResponseEntity(null, HttpStatus.OK);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error during processing request bundle");
        }
    }

}
