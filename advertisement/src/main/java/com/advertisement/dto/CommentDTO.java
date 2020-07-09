package com.advertisement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
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


    }
