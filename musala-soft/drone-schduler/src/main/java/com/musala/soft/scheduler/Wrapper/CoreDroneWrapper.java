package com.musala.soft.scheduler.Wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoreDroneWrapper {
    @JsonProperty(value = "id")
    Long id;
    @JsonProperty(value = "serialNumber")
    String serialNumber;
    @JsonProperty(value = "model")
    String model;
    @JsonProperty(value = "weight")
    Float weight;
    @JsonProperty(value = "batteryCapacity")
    Float batteryCapacity;
    @JsonProperty(value = "status")
    String status;

    public CoreDroneWrapper(Long id, String serial, String model, Float weight, Float battery,
                            String status) {
        this.id = id;
        this.serialNumber = serial;
        this.model = model;
        this.weight =weight;
        this.batteryCapacity = battery;
        this.status = status;
    }
}
