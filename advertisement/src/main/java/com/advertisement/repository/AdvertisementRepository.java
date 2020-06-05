package com.advertisement.repository;

import com.advertisement.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    @Query(value = "select count(a) from Advertisement a where a.ownerId = ?1 ")
    int findAllCount(Long id);

    @Query(value = "select a from Advertisement a where a.endDate >= ?1")
    List<Advertisement> findAll(LocalDate today);
}
