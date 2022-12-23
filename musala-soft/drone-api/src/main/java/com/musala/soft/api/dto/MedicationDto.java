package com.musala.soft.api.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@ToString
public class MedicationDto {
    byte[] image;
    String imageType;
    String name;
    Float weight;
    String code;
}
