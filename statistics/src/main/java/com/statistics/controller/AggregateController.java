package com.statistics.controller;

import com.statistics.dto.CommentAndRateDTO;
import com.statistics.service.AggregateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value="/aggregate")
@RequiredArgsConstructor
public class AggregateController {

    @Autowired
    AggregateService aggregateService;

    @GetMapping(value = "commentAndRate/{id}", produces = "application/json")
    //@PreAuthorize("hasAuthority('ROLE_CLIENT')")
    @PermitAll
    public ResponseEntity<?> getCommentedAndRatedRequ(@PathVariable long id) {

        CommentAndRateDTO dto = this.aggregateService.getCommentedAndRatedRequ(id);

        return new ResponseEntity(dto, HttpStatus.OK);
    }

}
