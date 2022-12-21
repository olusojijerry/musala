package com.musala.soft.repo.repository;

import com.musala.soft.entity.drones.CoreMedicationDrone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoreDroneMedicationRepository extends JpaRepository<CoreMedicationDrone, Long> {
}
