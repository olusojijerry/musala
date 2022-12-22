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
    @Column(name = "MedicationId")
    Long medicationId;
    @Column(name = "Status")
    String status;
    @Column(name = "Quantity", nullable = false)
    Integer quantity;
    @ManyToOne
    @JoinColumn(name = "core_drone_trip_id")
    private CoreDroneTrip coreDroneTrip;

    public CoreDroneTrip getCoreDroneTrip() {
        return coreDroneTrip;
    }

    public void setCoreDroneTrip(CoreDroneTrip coreDroneTrip) {
        this.coreDroneTrip = coreDroneTrip;
    }
}
