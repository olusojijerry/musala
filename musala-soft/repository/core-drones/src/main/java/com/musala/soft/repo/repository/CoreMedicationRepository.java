package com.musala.soft.repo.repository;

import com.musala.soft.entity.drones.CoreMedication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoreMedicationRepository extends JpaRepository<CoreMedication, Long> {
    Optional<CoreMedication> findByCode(String code);
}
