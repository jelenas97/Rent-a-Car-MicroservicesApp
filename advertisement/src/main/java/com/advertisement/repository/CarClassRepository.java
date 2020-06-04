package com.advertisement.repository;

import com.advertisement.model.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarClassRepository extends JpaRepository<CarClass, Long> {

    CarClass findByName(String name);

    @Query(value = "select c from CarClass c where c.active=true")
    List<CarClass> getActiveCarClasses();
}
