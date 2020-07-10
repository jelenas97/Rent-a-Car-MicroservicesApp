package com.rent.controller;

import com.rent.dto.RentRequestDTO;
import com.rent.dto.RequestsHolderDTO;
import com.rent.service.RentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "rentRequest")
public class RentRequestController {

    @Autowired
    private RentRequestService rentRequestService;

    @GetMapping(value = "/history/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    // @PreAuthorize("hasAuthority('ROLE_CLIENT')")
    @PermitAll
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
    @PermitAll
    public ResponseEntity<List<RentRequestDTO>> getCancelableRentRequests(@PathVariable String id) {
        try {
            return new ResponseEntity<>(rentRequestService.getCancelableRentRequests(Long.parseLong(id)), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/paid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAuthority('ROLE_CLIENT')")
    @PermitAll
    public ResponseEntity<List<RentRequestDTO>> getPaidRentRequests(@PathVariable String id) {
        try {
            return new ResponseEntity<>(rentRequestService.getPaidRentRequests(Long.parseLong(id)), HttpStatus.OK);
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
            this.rentRequestService.sendRequest(holderDTO);
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
            this.rentRequestService.processRequestsBundle(confirm, holderDTO);
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (NoSuchAlgorithmException | KeyManagementException | URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error during processing request bundle");
        }
    }

    @PostMapping(value = "/request/{confirm}", produces = "application/json")
    //   @PreAuthorize("hasAuthority('ROLE_AGENT')")
    @PermitAll
    public ResponseEntity<?> processRequest(@PathVariable String confirm, @RequestBody RentRequestDTO rentDTO) {
        try {
            this.rentRequestService.processRequest(confirm, rentDTO);
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (NoSuchAlgorithmException | KeyManagementException | URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error during processing request bundle");
        }
    }

    @PostMapping(value = "/physicalRent", produces = "application/json")
    //  @PreAuthorize("hasAuthority('ROLE_AGENT')")
    @PermitAll
    public ResponseEntity<?> physicalRent(@RequestBody RentRequestDTO rentDTO) {
        try {
            this.rentRequestService.physicalRent(rentDTO);
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (NoSuchAlgorithmException | KeyManagementException | URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error during processing request bundle");
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json" )
    public RentRequestDTO getRentRequest(@PathVariable("id") String id){
        return this.rentRequestService.getRentRequest(id);
    }

    @GetMapping(value = "/user/{id}/reserved", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAuthority('ROLE_CLIENT')")
    public ResponseEntity<List<RentRequestDTO>> getRentRequestsReserved(@PathVariable String id) {
        try {
            return new ResponseEntity<>(rentRequestService.getRentRequestReserved(Long.parseLong(id)), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/cancel/{id}")
    //@PreAuthorize("hasAuthority('ROLE_CLIENT')")
    @PermitAll
    public ResponseEntity cancelRentRequest(@PathVariable long id){
        try{
            RentRequestDTO rrDTO = rentRequestService.cancelRentRequest(id);
            return  new ResponseEntity(rrDTO, HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/pay/{id}")
    //@PreAuthorize("hasAuthority('ROLE_CLIENT')")
    @PermitAll
    public ResponseEntity payRentRequest(@PathVariable long id){
        try{
            RentRequestDTO rrDTO = rentRequestService.payRentRequest(id);
            return  new ResponseEntity(rrDTO, HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


}
