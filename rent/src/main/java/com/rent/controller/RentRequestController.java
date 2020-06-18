package com.rent.controller;

import com.rent.client.AdvertisementClient;
import com.rent.dto.*;
import com.rent.enumerations.RentRequestStatus;
import com.rent.model.RentRequest;
import com.rent.model.RequestsHolder;
import com.rent.repository.RentRequestRepository;
import com.rent.service.RentRequestService;
import com.rent.service.RequestsHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
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

    @Autowired
    private RequestsHolderService requestsHolderService;

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
    @PermitAll
    public ResponseEntity sentRequest(@RequestBody RequestsHolderDTO holderDTO) {
        try {
            System.out.println("Posal zahtjev " + holderDTO);
            Set<Long> usersIds = new HashSet<>();
            for (RentRequestDTO requestDTO : holderDTO.getRentRequests()) {
                AdvertisementDTO ad = this.advertisementClient.getAdvertisement(requestDTO.getAdvertisementId());
                usersIds.add(ad.getOwnerID());
            }
            System.out.println("Owners:" + usersIds);
            for (Long id : usersIds) {
                RequestsHolder rq = new RequestsHolder(holderDTO.getBundle());
                System.out.println("Vlasnik = " + id);

                for (RentRequestDTO requestDTO : holderDTO.getRentRequests()) {
                    AdvertisementDTO ad = this.advertisementClient.getAdvertisement(requestDTO.getAdvertisementId());

                    if (id.equals(ad.getOwnerID())) {
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
    @PermitAll
    public ResponseEntity<?> processRequestsBundle(@PathVariable String confirm, @RequestBody RequestsHolderDTO holderDTO) {
        try {
            if (confirm.equals("YES")) {
                //true = nema preklapanja  u jednom terminu! Dodaj ih sve!
                //false = ima preklapanja u jednom/vise! Sve odbij!
                Boolean yes = true;
                for (RentRequestDTO rentDTO : holderDTO.getRentRequests()) {
                    System.out.println(rentDTO);
                    TermSearchDTO termSearchDTO = new TermSearchDTO(rentDTO.getAdvertisementId(), rentDTO.getStartDateTime(), rentDTO.getEndDateTime());
                    List<TermDTO> term = this.advertisementClient.getTakenTerms(termSearchDTO);
                    System.out.println("Zauzeti termini su " + term.toString());
                    if (term.size() != 0) {
                        yes = false;
                    }
                }
                if (yes) {
                    for (RentRequestDTO rentDTO : holderDTO.getRentRequests()) {
                        RentRequest request = this.rentRequestRepository.findById(rentDTO.getId()).orElse(null);
                        List<RentRequest> rentRequests = this.rentRequestService.findPending(rentDTO.getAdvertisementId(), rentDTO.getStartDateTime(), rentDTO.getEndDateTime());
                        if (request != null) {
                            this.rentRequestService.rent(request);
                            this.automaticRejection(rentRequests);

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
    //Accept or reject requests from users!
    @PostMapping(value = "/request/{confirm}", produces = "application/json")
    //   @PreAuthorize("hasAuthority('ROLE_AGENT')")
    @PermitAll
    public ResponseEntity<?> processRequest(@PathVariable String confirm, @RequestBody RentRequestDTO rentDTO) {
        try {
            List<RentRequest> rentRequests = this.rentRequestService.findPending(rentDTO.getAdvertisementId(), rentDTO.getStartDateTime(), rentDTO.getEndDateTime());

            if (confirm.equals("YES")) {
                System.out.println(rentDTO);
                TermSearchDTO termSearchDTO = new TermSearchDTO(rentDTO.getAdvertisementId(), rentDTO.getStartDateTime(), rentDTO.getEndDateTime());
                List<TermDTO> term = this.advertisementClient.getTakenTerms(termSearchDTO);
                System.out.println("Zauzeti termini su " + term.toString());

                if (term.size() == 0) {
                    System.out.println("NEMA TERMINA SA PREKLAPANJEM!!!!");
                    RentRequest request = this.rentRequestRepository.findById(rentDTO.getId()).orElse(null);
                    if (request != null) {
                        this.rentRequestService.rent(request);
                        this.automaticRejection(rentRequests);
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
    @PermitAll
    public ResponseEntity<?> physicalRent(@RequestBody RentRequestDTO rentDTO) {
        try {
            System.out.println("Physical rent " + rentDTO);
            RentRequest req1 = new RentRequest(rentDTO, rentDTO.getSenderId(),rentDTO.getAdvertisementId(),null,RentRequestStatus.RESERVED);
            rentRequestService.save(req1);
            RentRequest req = this.rentRequestRepository.findById(req1.getId()).orElse(null);
            if (req != null) {
                this.rentRequestService.rent(req);
            }
            //automatsko odbijanje
            List<RentRequest> rentRequests = this.rentRequestService.findPending(rentDTO.getAdvertisementId(), rentDTO.getStartDateTime(), rentDTO.getEndDateTime());
            System.out.println("OVI SU VEC POSTOJALI: " + rentRequests);

            this.automaticRejection(rentRequests);

            return new ResponseEntity(null, HttpStatus.OK);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error during processing request bundle");
        }
    }

    @Transactional
    public void automaticRejection(List<RentRequest> rentRequests) {
        for (RentRequest request : rentRequests) {
            if (request.getRequests().getBundle()) {
                AdvertisementDTO ad = this.advertisementClient.getAdvertisement(request.getAdvertisementId());
                List<RequestsHolderDTO> holders = this.requestsHolderService.getAllPending(ad.getOwnerID());
                System.out.println("Postojali su holderi : " + holders);
                for (RequestsHolderDTO hold : holders) {
                    System.out.println("Postoji toliko request u holderu : " + hold);
                    for (RentRequestDTO holderRentRequest : hold.getRentRequests()) {
                        System.out.println("Ovo je bilo u bundle uklanjam!!!" + holderRentRequest.getId());
                        this.rentRequestService.changeStatus(holderRentRequest.getId(), "CANCELED");
                    }
                }
            } else {
                this.rentRequestService.changeStatus(request.getId(), "CANCELED");
            }
        }

    }


}
