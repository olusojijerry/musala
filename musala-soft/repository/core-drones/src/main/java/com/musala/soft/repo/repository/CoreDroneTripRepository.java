package com.musala.soft.repo.repository;

import com.musala.soft.entity.drones.CoreDroneTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CoreDroneTripRepository extends JpaRepository<CoreDroneTrip, Long> {
    List<CoreDroneTrip> findAllBySerialNumber(String serialNumber);
    @Query(value = "select * from drone_trip where createddt between :fromDate and :to", nativeQuery = true)
    List<CoreDroneTrip> findAllByCreatedDt(Date fromDate, Date toDate);
}
