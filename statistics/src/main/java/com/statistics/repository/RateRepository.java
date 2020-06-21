package com.statistics.repository;


import com.statistics.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate, Long> {

    List<Rate> findByClientId(long id);
    List<Rate> findByAdvertisementId(long id);
    boolean findByRentRequestId(long id);
}
