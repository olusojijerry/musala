package com.musala.soft.api.endpoint;

import com.musala.soft.api.dto.MedicationDto;
import com.musala.soft.api.services.MedicationService;
import com.musala.soft.entity.drones.CoreMedication;
import com.musala.soft.resources.pojo.RestResponsePojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("api/medication")
@Slf4j
public class MedicationEndPoint {
    @Autowired
    MedicationService medicationService;

    @PostMapping("")
    public RestResponsePojo<CoreMedication> createMedication(@Valid @RequestBody MedicationDto medicationDto) throws IOException {
        RestResponsePojo<CoreMedication> restResponsePojo = new RestResponsePojo<>();

        restResponsePojo.setMessage("Successful");
        restResponsePojo.setData(medicationService.createMedication(medicationDto));

        return restResponsePojo;
    }

}
