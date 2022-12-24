package com.musala.soft.api.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;

@Data
@ToString
public class MedicationDto {
    byte[] image;
    @NotNull(message = "Image type cannot be null or empty")
    String imageType;
    @NotNull(message = "Name cannot be null or empty")
    String name;
    @Min(value = 0)
    Float weight;
    @NotNull(message = "The code value cannot be empty or null")
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$",
            message = "code must contain digit 0-9, alphabet a-z, A-Z, - and _")
    String code;
}
