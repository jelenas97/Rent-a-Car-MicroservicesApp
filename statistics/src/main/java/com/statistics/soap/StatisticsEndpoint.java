package com.statistics.soap;

import com.statistics.service.CommentService;
import com.statistics.soap.code.CommentRequest;
import com.statistics.soap.code.CommentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.LocalDate;

@Endpoint
public class StatisticsEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8095/microservices/statistics";

    @Autowired
    private CommentService commentService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "commentRequest")
    @ResponsePayload
    public CommentResponse commentResponse(@RequestPayload CommentRequest request) {
        System.out.println("Soap request");


        CommentResponse response = new CommentResponse();

        com.statistics.dto.CommentDTO commentDTO = new com.statistics.dto.CommentDTO();
        commentDTO.setAdvertisement_id(request.getAdvertisementId());

        LocalDate date = LocalDate.parse(request.getDate());

        commentDTO.setDate(date);
        commentDTO.setDateString(date.toString());
        commentDTO.setContent(request.getContent());
        commentDTO.setStatus(request.getStatus());
        commentDTO.setCommenter_id(request.getCommenterId());
        commentDTO.setCommenter(request.getCommenter());
        commentDTO.setRent_request_id(request.getRentRequestId());
        long id = this.commentService.addCommentOwner(commentDTO);

        response.setCommentId(id);

        System.out.println("zavrsio request");
        return response;

    }
}
