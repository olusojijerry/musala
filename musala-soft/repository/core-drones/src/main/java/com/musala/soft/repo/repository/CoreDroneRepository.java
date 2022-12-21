package com.musala.soft.repo.repository;

import com.musala.soft.entity.drones.CoreDrone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CoreDroneRepository extends JpaRepository<CoreDrone, Long> {
    @Query(value = "select Count(*) from drones where serial_number like :date", nativeQuery = true)
    public Long getTotalCountOfDrone(@Param("date") String date);
}
