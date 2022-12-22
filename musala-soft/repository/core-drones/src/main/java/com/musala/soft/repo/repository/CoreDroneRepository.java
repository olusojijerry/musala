package com.musala.soft.repo.repository;

import com.musala.soft.entity.drones.CoreDrone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CoreDroneRepository extends JpaRepository<CoreDrone, Long> {
    @Query(value = "select Count(*) from drones where serial_number like :date", nativeQuery = true)
    public Long getTotalCountOfDrone(@Param("date") String date);

    List<CoreDrone> findByStatus(String status);
    Optional<CoreDrone> findBySerialNumber(String serialNumber);
}
