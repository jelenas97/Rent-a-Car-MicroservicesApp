package com.rent.repository;

import com.rent.model.RequestsHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestsHolderRepository extends JpaRepository<RequestsHolder, Long> {
//    @Query(value = "select c from RequestsHolder c inner join c.rentRequests req inner join req.advertisement a where req.rentRequestStatus='PENDING' and a.owner.id=?1 group by c.id")
//    List<RequestsHolder> getAllPending(Long id);
}