package com.musala.soft.entity.drones;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Table(name = "DroneTrip")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoreDroneTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;
    @Column(name = "TripId", nullable = false)
    String tripId;
    @Column(name = "Destination", nullable = false)
    String destination;
    @Column(name = "Distance", nullable = false)
    Long distance;
    @Column(name = "CreatedDt", nullable = false)
    Date createdDt;
    @Column(name = "DroneId", nullable = false)
    Long droneId;
    @Column(name = "Status", nullable = false)
    String status;
    @Column(name = "LastActivityDt")
    Date lastActivityDt;
}
