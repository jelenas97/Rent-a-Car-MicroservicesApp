package com.authentication.repository;

import com.authentication.model.RegisterRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRequestRepository extends JpaRepository<RegisterRequest, Long> {
}
