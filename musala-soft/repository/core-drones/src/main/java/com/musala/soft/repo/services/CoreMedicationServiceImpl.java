package com.musala.soft.repo.services;

import com.musala.soft.entity.drones.CoreMedication;
import com.musala.soft.repo.repository.CoreMedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class CoreMedicationServiceImpl implements CoreMedicationService{
    @Autowired
    CoreMedicationRepository coreMedicationRepository;
    @Override
    public CoreMedication saveOrUpadate(CoreMedication coreMedication) {
        return coreMedicationRepository.save(coreMedication);
    }

    @Override
    public Optional<CoreMedication> findById(Long id) {
        return coreMedicationRepository.findById(id);
    }

    @Override
    public Optional<CoreMedication> findByCode(String code) {
        return coreMedicationRepository.findByCode(code);
    }

    @Override
    public Page<CoreMedication> findAll(String code, String name, Pageable pageable) {
        return coreMedicationRepository.findAll(pageable);
    }
}
