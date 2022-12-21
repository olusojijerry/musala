package com.musala.soft.repo.repository;

import com.musala.soft.entity.drones.CoreDroneActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoreDroneActivityRepository extends JpaRepository<CoreDroneActivity, Long> {
    List<CoreDroneActivity> findAllByDroneSerial(String droneSerial);
}
