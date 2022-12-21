package com.musala.soft.api.services;

import com.musala.soft.api.dto.MedicationDto;
import com.musala.soft.entity.drones.CoreMedication;
import com.musala.soft.repo.services.CoreMedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class MedicationService {
    @Autowired
    CoreMedicationService coreMedicationService;

    public CoreMedication createMedication(MedicationDto medicationDto) throws IOException {
        CoreMedication coreMedication = new CoreMedication();

        String mimeType = medicationDto.getImage().getContentType();
        byte[] image = medicationDto.getImage().getBytes();

        coreMedication.setCreatedDt(new Date());
        coreMedication.setImage(image);
        coreMedication.setImageType(mimeType);
        coreMedication.setName(medicationDto.getName());
        coreMedication.setWeight(medicationDto.getWeight());
        coreMedication.setCode(medicationDto.getCode());

        return coreMedicationService.saveOrUpadate(coreMedication);
    }
}
