package com.advertisement.controller;

import com.advertisement.dto.PriceListDTO;
import com.advertisement.model.PriceList;
import com.advertisement.service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "priceList")
@CrossOrigin("http://localhost:4200")

public class PriceListController {

    @Autowired
    private PriceListService pricelistService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    //@PreAuthorize("hasAuthority('ROLE_AGENT') or hasAuthority('ROLE_CLIENT')")
    @PermitAll
    public ResponseEntity createPricelist(@RequestBody PriceListDTO dto) {

        PriceList pricelist =this.pricelistService.createNewPriceList(dto);

        return new ResponseEntity(pricelist.getId(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/creator/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAuthority('ROLE_AGENT') or hasAuthority('ROLE_CLIENT')")
    @PermitAll
    public ResponseEntity<List<PriceListDTO>> getOwnersPricelists(@PathVariable String id) {

        try {
            List<PriceListDTO> list = new ArrayList<>();
            list =pricelistService.getCreatorsPriceLists(Long.parseLong(id));
            return new ResponseEntity<List<PriceListDTO>>(list, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
