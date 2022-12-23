package com.musala.soft.repo.repository;

import com.musala.soft.entity.drones.CoreDroneTrip;
import com.musala.soft.entity.drones.CoreMedicationDrone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoreDroneMedicationRepository extends JpaRepository<CoreMedicationDrone, Long> {
    List<CoreMedicationDrone> findByCoreDroneTrip(CoreDroneTrip coreDroneTrip);
}
