package com.advertisement.repository;

import com.advertisement.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query(value = "select r from Report r where r.advertisement.id = ?1")
    List<Report> findAllByAdId(Long id);
}
