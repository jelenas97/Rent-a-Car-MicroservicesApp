package com.statistics.dto;

import com.statistics.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {
    private Long id;
    private LocalDate date;
    private String dateString;
    private String content;
    private String status;
    private Long advertisement_id;
    private Long commenter_id;
    private String commenter;
    private Long rent_request_id;

    public CommentDTO(Comment comment, UserDTO dto){
        this.id = comment.getId();
        this.date = comment.getDate();
        this.dateString=comment.getDate().toString();
        this.content = comment.getContent();
        this.status = comment.getStatus().toString();
        this.advertisement_id = comment.getAdvertisementId();
        this.commenter_id = comment.getUserId();
        this.commenter= dto.getFirstName()+" "+ dto.getLastName();
        this.rent_request_id= comment.getRentRequestId();
    }

    public CommentDTO(Comment comment, long a, UserDTO dto){
        this.id = comment.getId();
        this.date = comment.getDate();
        this.dateString=comment.getDate().toString();
        this.content = comment.getContent();
        this.status = comment.getStatus().toString();
        this.advertisement_id = comment.getAdvertisementId();
        this.commenter_id = comment.getUserId();
        this.commenter= dto.getFirstName()+" "+ dto.getLastName();
    }
}
