package com.musala.soft.api.dto;

import lombok.Data;

@Data
public class DroneDto {
    String model;
    Float weight;
    Float batteryCapacity;
    String state;
    String serial;
}
