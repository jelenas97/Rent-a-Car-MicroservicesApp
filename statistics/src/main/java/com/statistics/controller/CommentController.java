package com.statistics.controller;

import com.statistics.dto.CommentDTO;
import com.statistics.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;

@RestController
@RequestMapping(value = "/comment", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("http://localhost:4200")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping(produces="application/json")
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PermitAll
    public ResponseEntity<?> getUnComments(){

        try {
            List<CommentDTO> users = this.commentService.findUnprocessed();
            return new ResponseEntity(users, HttpStatus.OK);

        }catch(NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error while loading users");
        }
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    //@PreAuthorize("hasRole('ADMIN')")
    @PermitAll
    public ResponseEntity changeStatus(@RequestBody CommentDTO commentDTO) {

        try {
            this.commentService.changeStatus(commentDTO);
            return new ResponseEntity(HttpStatus.OK);

        } catch (NullPointerException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    //@PreAuthorize("hasAuthority('ROLE_CLIENT')")
    @PermitAll
    public ResponseEntity<?> addComment(@RequestBody CommentDTO dto) {

        try {
            long id = this.commentService.addComment(dto);
            return new ResponseEntity(id, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value="/owner", produces = "application/json", consumes = "application/json")
    //@PreAuthorize("hasAnyAuthority('ROLE_CLIENT','ROLE_AGENT')")
    @PermitAll
    public ResponseEntity<?> addCommentOwner(@RequestBody CommentDTO dto) {

        try {
            long id = this.commentService.addCommentOwner(dto);
            return new ResponseEntity(id, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value="/{id}", produces="application/json")
    //@PreAuthorize("hasAnyAuthority('ROLE_CLIENT','ROLE_AGENT')")
    @PermitAll
    public ResponseEntity<?> getProcessedAdvertisementComments(@PathVariable Long id){

        try {
            List<CommentDTO> comments = this.commentService.findProcessedAdvertisementComments(id);

            return new ResponseEntity(comments, HttpStatus.OK);

        }catch(NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error while loading comments");
        }
    }
}
