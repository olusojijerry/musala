package com.musala.soft.entity.drones;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "DroneActivity")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoreDroneActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;
    @Column(name = "Status")
    String status;
    @Column(name = "BatteryCapacity")
    Float batteryCapacity;
    @Column(name = "CreatedDt")
    Date createdDt;
    @Column(name = "DroneSerial")
    String droneSerial;
    @Column(name = "Destination")
    String destination;
    @Column(name = "Action")
    String action;
}
