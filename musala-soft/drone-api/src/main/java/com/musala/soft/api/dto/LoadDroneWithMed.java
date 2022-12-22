package com.musala.soft.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class LoadDroneWithMed {
    String availableDroneCode;
    String destination;
    Long distance;
    List<MedToBeLoaded> medsToBeLoaded;
}
