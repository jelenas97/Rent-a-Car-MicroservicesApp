package com.advertisement.repository;

import com.advertisement.model.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceListRepository extends JpaRepository<PriceList, Long> {

    List<PriceList> findByCreatorId(Long id);
}
