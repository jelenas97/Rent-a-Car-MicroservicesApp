package com.advertisement.repository;

import com.advertisement.model.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList, Long> {
    @Query(value = "select p from PriceList p where p.creatorId=?1")
    List<PriceList> findByCreatorId(Long id);

    PriceList findByAdvertisementId(Long id);
}
