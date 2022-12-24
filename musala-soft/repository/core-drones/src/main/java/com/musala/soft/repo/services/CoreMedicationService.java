package com.musala.soft.repo.services;

import com.musala.soft.entity.drones.CoreMedication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CoreMedicationService {
    CoreMedication saveOrUpadate(CoreMedication coreMedication);
    Optional<CoreMedication> findById(Long id);
    Optional<CoreMedication> findByCode(String code);
    Page<CoreMedication> findAll(String code, String name, Pageable pageable);
    CoreMedication saveOrUpdateFlush(CoreMedication coreMedication);
}
