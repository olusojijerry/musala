package com.musala.soft.api.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;

@Data
@ToString
public class MedicationDto {
    @NotEmpty(message = "Select an image for the medication")
    byte[] image;
    @NotEmpty(message = "Image type cannot be null or empty")
    String imageType;
    @NotNull(message = "Name cannot be null or empty")
    String name;
    @Min(value = 0)
    Float weight;
    @NotNull(message = "The code value cannot be empty or null")
    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[-_])(?=.*[0-9]))$",
            message = "code must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    String code;
}
