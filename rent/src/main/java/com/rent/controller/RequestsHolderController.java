package com.rent.controller;

import com.rent.service.RequestsHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "requestHolder")
@CrossOrigin("http://localhost:4200")
public class RequestsHolderController {

    @Autowired
    private RequestsHolderService requestsHolderService;

    @GetMapping(value = "/{id}", produces = "application/json")
    //    @PreAuthorize("hasAnyAuthority('ROLE_CLIENT','ROLE_AGENT')")
    public ResponseEntity<?> getRequestHolders(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(this.requestsHolderService.getRequestHolders(id), HttpStatus.OK);
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
