package com.advertisement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;
    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;
    @Column(name = "period")
    private Period period;
    @Column(name = "canceled")
    private Boolean canceled;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Advertisement advertisement;

    public Term(LocalDate startDate, LocalDate endDate, Advertisement advertisement) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.period = Period.between(startDate, endDate);
        this.advertisement = advertisement;
        this.canceled = false;
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", canceled=" + canceled +
                '}';
    }
}
