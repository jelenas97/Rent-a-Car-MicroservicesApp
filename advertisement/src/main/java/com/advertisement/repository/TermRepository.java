package com.advertisement.repository;

import com.advertisement.model.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TermRepository extends JpaRepository<Term, Long> {
    @Query(value = "select t from Term t where t.advertisement.id = ?1 and t.canceled=false and t.startDate <= ?2 and t.endDate >= ?2 " +
            "or t.advertisement.id = ?1 and t.canceled=false and t.startDate <= ?2 and t.endDate >= ?3 " +
            "or t.advertisement.id = ?1 and t.canceled=false and t.startDate >= ?2 and t.endDate <= ?3")
    List<Term> findTakenTerm(Long id, LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT term from Term term inner join Advertisement adv ON term.advertisement = adv where adv.ownerId = ?1")
    List<Term> getAllRentedByAgentId(Long id);

    @Query(value = "SELECT term FROM Term term where term.reportWritten = true")
    List<Term> getAllWithReports();
}
