package com.rent.repository;

import com.rent.enumerations.RentRequestStatus;
import com.rent.model.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface RentRequestRepository extends JpaRepository<RentRequest, Long> {
    List<RentRequest> findBySenderIdAndRentRequestStatusAndEndDateTimeLessThanEqual(long id, RentRequestStatus status, LocalDateTime dateTime);

    List<RentRequest> findBySenderIdAndRentRequestStatusIn(long id, List<RentRequestStatus> statuses);

    @Query(value = "select a from RentRequest a where a.id = ?1")
    RentRequest find(Long id);

    @Query(value = "select t from RentRequest t where t.advertisementId = ?1 and t.rentRequestStatus='PENDING' and t.startDateTime <= ?2 and t.endDateTime >= ?2 " +
            "or t.rentRequestStatus='PENDING' and t.advertisementId = ?1 and t.startDateTime <= ?3 and t.endDateTime >= ?3 " +
            "or t.rentRequestStatus='PENDING' and t.advertisementId = ?1 and t.startDateTime >= ?2 and t.endDateTime <= ?3")
    List<RentRequest> findPending(Long id, LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "select t from RentRequest t where t.rentRequestStatus='PENDING' and t.created <= ?1")
    List<RentRequest> findOldRequests(LocalDateTime yesterday);

    @Query(value = "select t from RentRequest t where t.senderId = ?1 and t.rentRequestStatus='RESERVED'")
    List<RentRequest> findBySenderIdAndStatus(long id);

    @Query(value = "select t from RentRequest t where t.advertisementId in (?1) and t.rentRequestStatus='RESERVED'")
    List<RentRequest> findByOwnerIdAndStatus(List<Long> ids);
    @Query(value = "select t from RentRequest t where t.requests.id = ?1 and t.rentRequestStatus='PENDING'")
    List<RentRequest> getHolderRequests(Long id);
}
