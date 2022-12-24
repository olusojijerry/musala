package com.musala.soft.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SetDroneStatus {
    @NotNull(message = "Select a drone")
    String serialNumber;
    @NotNull(message = "Select the status you want to update to")
    String status;
}
