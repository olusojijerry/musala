package com.musala.soft.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class DroneMedResponse {
    String droneCode;
    String destination;
    String tripId;
    Float totalWeight;
    List<MedToBeLoaded> medsToBeLoaded;
}
