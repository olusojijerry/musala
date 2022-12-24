package com.musala.soft.api.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class MedToBeLoaded {
    @Min(value = 0, message = "Quantity must be greater than 0")
    Integer quantity;
    @NotNull(message = "Select a particular medication")
    String medicationCode;
}
