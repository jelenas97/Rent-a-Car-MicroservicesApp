package com.statistics.dto;

import com.statistics.adapter.LocalDateAdapter;
import com.statistics.model.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommentDTO", namespace = "http://localhost:8090/microservices/statistics")
@XmlRootElement(name = "commentDTOClass")
public class CommentDTO {
    @XmlElement
    private Long id;
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @XmlElement
    private LocalDate date;
    @XmlElement
    private String dateString;
    @XmlElement
    private String content;
    @XmlElement
    private String status;
    @XmlElement
    private Long advertisement_id;
    @XmlElement
    private Long commenter_id;
    @XmlElement
    private String commenter;
    @XmlElement
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
