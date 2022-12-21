package com.musala.soft.entity.drones;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "Drones", uniqueConstraints = @UniqueConstraint(columnNames = {"SerialNumber"}))
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoreDrone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;
    @Column(name = "SerialNumber", length = 100)
    String serialNumber;
    @Column(name = "Model")
    String model;
    @Column(name = "Weight")
    Float weight;
    @Column(name="Status")
    String status;
    @Column(name = "BatteryCapacity")
    Float batteryCapacity;
    @Column(name = "CreatedDt")
    Date createdDt;
    @Column(name = "LastActivityDt")
    Date lastActivityDt;
}
