package com.musala.soft.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DroneDto {
    @NotNull(message = "Select the model type for the drone")
    String model;
    Float weight;
    Float batteryCapacity;
    @NotNull(message = "Select the state for the drone")
    String state;
    @NotNull(message = "Serial number cannot be null or empty")
    String serial;
}
