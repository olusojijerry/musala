package com.musala.soft.api.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class LoadDroneWithMed {
    @NotNull(message = "Select the available drone")
    String availableDroneCode;
    @NotNull(message = "Enter the destination code")
    String destination;
    @Min(value = 0)
    Long distance;
    @Valid
    List<MedToBeLoaded> medsToBeLoaded;
}
