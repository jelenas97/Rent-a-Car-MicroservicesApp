package com.advertisement.model;

import com.advertisement.adapter.LocalDateAdapter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;


@Entity
@Setter
@Getter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "startDate", nullable = false)
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate startDate;

    @Column(name = "endDate", nullable = false)
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    private LocalDate endDate;

    @Column(name = "canceled")
    private Boolean canceled;

    @Column
    private Boolean reportWritten;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "advertisement_id", nullable = false)
    private Advertisement advertisement;

    public Term(LocalDate startDate, LocalDate endDate, Advertisement advertisement) {
        this.startDate = startDate;
        this.endDate = endDate;
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
