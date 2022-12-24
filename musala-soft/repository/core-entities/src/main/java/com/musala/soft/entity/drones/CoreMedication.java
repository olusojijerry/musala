package com.musala.soft.entity.drones;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "Medications", uniqueConstraints = @UniqueConstraint(columnNames = "Code"))
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoreMedication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;
    @Column(name = "Name")
    String name;
    @Column(name = "Weight")
    Float weight;
    @Column(name = "Code")
    String code;
    @Column(name = "Image", length = 4000)
    byte[] image;
    @Column(name = "CreatedDt")
    Date createdDt;
    @Column(name = "LastActivityDt")
    Date lastActivityDt;
    @Column(name = "ImageType")
    String imageType;

    public CoreMedication() {
    }

    public CoreMedication(String name, Float weight, String code, byte[] image, String imageType) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;
        this.imageType = imageType;
    }
}
