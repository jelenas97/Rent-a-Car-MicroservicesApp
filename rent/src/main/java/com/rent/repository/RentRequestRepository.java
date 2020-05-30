package com.rent.repository;

import com.rent.model.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRequestRepository extends JpaRepository<RentRequest, Long> {

}
