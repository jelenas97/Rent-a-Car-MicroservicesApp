package com.rent.controller;

import com.rent.client.AdvertisementClient;
import com.rent.dto.AdvertisementDTO;
import com.rent.dto.RentRequestDTO;
import com.rent.dto.RequestsHolderDTO;
import com.rent.enumerations.RentRequestStatus;
import com.rent.model.RentRequest;
import com.rent.model.RequestsHolder;
import com.rent.repository.RentRequestRepository;
import com.rent.service.RentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "rentRequest")
public class RentRequestController {
    @Autowired
    private RentRequestRepository rentRequestRepository;

    @Autowired
    private RentRequestService rentRequestService;

    @Autowired
    private AdvertisementClient advertisementClient;

    @GetMapping(path = "/test",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public AdvertisementDTO getRentRequests() {
        System.out.print("OVO NAM VRACA??? :) " + this.advertisementClient.getAdvertisement());
        return this.advertisementClient.getAdvertisement();
    }

//    @GetMapping(path = "/test/config",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<RentRequest> save() {
//        for (int i = 0; i < 10; i++) {
//            RentRequest request = new RentRequest();
//            request.setStatus("NOVI");
//            this.rentRequestRepository.save(request);
//        }
//        return this.rentRequestRepository.findAll();
//    }


    @GetMapping(value = "/history/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    // @PreAuthorize("hasAuthority('ROLE_CLIENT')")
    public ResponseEntity<List<RentRequestDTO>> getHistoryRentRequests(@PathVariable String id) {
        try {
            return new ResponseEntity<>(rentRequestService.getHistoryRentRequests(Long.parseLong(id)), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/cancelable/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAuthority('ROLE_CLIENT')")
    public ResponseEntity<List<RentRequestDTO>> getCancelableRentRequests(@PathVariable String id) {
        try {
            return new ResponseEntity<>(rentRequestService.getCancelableRentRequests(Long.parseLong(id)), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    // @PreAuthorize("hasAuthority('ROLE_AGENT') and hasAuthority('ROLE_CLIENT')")
    public ResponseEntity sentRequest(@RequestBody RequestsHolderDTO holderDTO) {
        try {
            System.out.println("Posal zahtjev " + holderDTO);
            Set<Long> usersIds = new HashSet<>();
            for (RentRequestDTO requestDTO : holderDTO.getRentRequests()) {
                usersIds.add(requestDTO.getAdvertisementId());
            }
            for (Long id : usersIds) {
                RequestsHolder rq = new RequestsHolder(holderDTO.getBundle());
                System.out.println("Vlasnik = " + id);

                for (RentRequestDTO requestDTO : holderDTO.getRentRequests()) {
                    if (id.equals(requestDTO.getAdvertisementId())) {
                        RentRequest rentRequest = new RentRequest(requestDTO, requestDTO.getSenderId(), requestDTO.getAdvertisementId(), rq);
                        System.out.println(rentRequest);
                        //treba i holder snimiti???
                        this.rentRequestService.save(rentRequest);
                    }
                }
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping(value = "/bundle/{confirm}", produces = "application/json")
    // @PreAuthorize("hasRole('AGENT')")
    public ResponseEntity<?> processRequestsBundle(@PathVariable String confirm, @RequestBody RequestsHolderDTO holderDTO) {
        try {
            if (confirm.equals("YES")) {
                //true = nema preklapanja  u jednom terminu! Dodaj ih sve!
                //false = ima preklapanja u jednom/vise! Sve odbij!
                Boolean yes = true;
                for (RentRequestDTO rentDTO : holderDTO.getRentRequests()) {
                    List<?> term = new ArrayList<>();
                    //    List<Term> term = this.termService.findTakenTerm(rentDTO.getAdvertisementId(), rentDTO.getStartDateTime(), rentDTO.getEndDateTime());
                    if (term.size() != 0) {
                        yes = false;
                    }
                }
                if (yes) {
                    for (RentRequestDTO rentDTO : holderDTO.getRentRequests()) {
                        RentRequest request = this.rentRequestRepository.findById(rentDTO.getId()).orElse(null);
                        if (request != null) {
                            this.rentRequestService.rent(request);
                        }
                    }
                } else {
                    for (RentRequestDTO rentDTO : holderDTO.getRentRequests()) {
                        this.rentRequestService.changeStatus(rentDTO.getId(), RentRequestStatus.CANCELED.toString());
                    }
                }
            } else {
                for (RentRequestDTO r : holderDTO.getRentRequests()) {
                    this.rentRequestService.changeStatus(r.getId(), RentRequestStatus.CANCELED.toString());
                }
            }
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error during processing request bundle");
        }
    }

    @PostMapping(value = "/request/{confirm}", produces = "application/json")
//    @PermitAll
    //   @PreAuthorize("hasAuthority('ROLE_AGENT')")
    public ResponseEntity<?> processRequest(@PathVariable String confirm, @RequestBody RentRequestDTO rentDTO) {
        try {
            if (confirm.equals("YES")) {
                System.out.println(rentDTO);
                List<?> term = new ArrayList<>();
                //  List<Term> term = this.termService.findTakenTerm(rentDTO.getAdvertisementId(), rentDTO.getStartDateTime(), rentDTO.getEndDateTime());
                if (term.size() == 0) {
                    System.out.println("NEMA TERMINA SA PREKLAPANJEM!!!!");
                    RentRequest request = this.rentRequestRepository.findById(rentDTO.getId()).orElse(null);
                    if (request != null) {
                        this.rentRequestService.rent(request);
                    }
                } else {
                    this.rentRequestService.changeStatus(rentDTO.getId(), RentRequestStatus.CANCELED.toString());
                }
            } else {
                this.rentRequestService.changeStatus(rentDTO.getId(), RentRequestStatus.CANCELED.toString());
            }
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error during processing request bundle");
        }
    }

    @PostMapping(value = "/physicalRent", produces = "application/json")
    //  @PreAuthorize("hasAuthority('ROLE_AGENT')")
    public ResponseEntity<?> physicalRent(@RequestBody RentRequestDTO rentDTO) {
        try {
            System.out.println("Physical rent " + rentDTO);
            RentRequest req = this.rentRequestRepository.findById(rentDTO.getId()).orElse(null);
            if (req != null) {
                this.rentRequestService.rent(req);
            }
            //automatsko odbijanje
            List<RentRequest> rentRequests = this.rentRequestService.findPending(rentDTO.getAdvertisementId(), rentDTO.getStartDateTime(), rentDTO.getEndDateTime());
            System.out.println("OVI SU VEC POSTOJALI: " + rentRequests);
            for (RentRequest request : rentRequests) {
                if (request.getRequests().getBundle()) {
//                    skontati sa fronta da se posalje ID vlasnika isto u requestu
//                    List<RequestsHolderDTO> holders = this.requestsHolderService.getAllPending(request.getAdvertisement().getOwner().getId());
//                    System.out.println("Postojali su holderi : " + holders);
//                    for (RequestsHolderDTO hold : holders) {
//                        System.out.println("Postoji toliko request u holderu : " + hold);
//                        for (RentRequestDTO holderRentRequest : hold.getRentRequests()) {
//                            System.out.println("Ovo je bilo u bundle uklanjam!!!" + holderRentRequest.getId());
//                            this.rentRequestService.changeStatus(holderRentRequest.getId(), "CANCELED");
//                        }
//                    }
                } else {
                    this.rentRequestService.changeStatus(request.getId(), "CANCELED");
                }
            }
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error during processing request bundle");
        }
    }


}
