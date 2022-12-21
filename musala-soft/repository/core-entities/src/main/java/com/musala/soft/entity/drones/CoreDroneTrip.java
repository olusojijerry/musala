package com.musala.soft.entity.drones;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "DroneTrip")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoreDroneTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;
    @Column(name = "DroneId", nullable = false)
    Long droneId;
    @Column(name = "TripId", nullable = false)
    String tripId;
    @Column(name = "Destination", nullable = false)
    String destination;
    @Column(name = "SerialNumber", nullable = false)
    String serialNumber;
    @Column(name = "Distance", nullable = false)
    Long distance;
    @Column(name = "CreatedDt", nullable = false)
    Date createdDt;
}
