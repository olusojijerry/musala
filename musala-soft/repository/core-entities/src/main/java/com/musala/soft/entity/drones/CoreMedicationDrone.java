package com.musala.soft.entity.drones;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "MedicationDrone")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoreMedicationDrone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;
    @Column(name = "CreatedDt")
    Date createdDt;
    @Column(name = "DroneId")
    Long droneId;
    @Column(name = "MedicationId")
    Long medicationId;
    @Column(name = "Status")
    String status;
}
