package com.statistics.model;

import com.statistics.enumerations.ApproveStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;

    @Column
    private String content;

    @Enumerated(EnumType.STRING)
    private ApproveStatus status;

    @Column
    private Long advertisementId;

    @Column
    private Long userId;

    @Column
    private Long rentRequestId;

}
