package com.musala.soft.entity.drones;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MedicationId")
    CoreMedication medication;
    @Column(name = "Quantity", nullable = false)
    Integer quantity;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "DroneTripId", referencedColumnName = "Id")
    private CoreDroneTrip coreDroneTrip;

}
