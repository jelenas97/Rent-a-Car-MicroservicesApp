package com.advertisement.repository;

import com.advertisement.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    @Query(value = "select count(a) from Advertisement a where a.ownerId = ?1 ")
    int findAllCount(Long id);
}
