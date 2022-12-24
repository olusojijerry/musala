package com.musala.soft.api;

import com.musala.soft.api.dto.LoadDroneWithMed;
import com.musala.soft.api.dto.MedToBeLoaded;
import com.musala.soft.api.services.DroneService;
import com.musala.soft.entity.drones.*;
import com.musala.soft.repo.services.CoreDroneService;
import com.musala.soft.repo.services.CoreMedicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class DroneApi {
    @Autowired
    CoreDroneService coreDroneService;
    @Autowired
    CoreMedicationService coreMedicationService;
    @Autowired
    DroneService droneService;
    public static void main(String[] args){
        SpringApplication.run(DroneApi.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            CoreDrone coreDrone1 = new CoreDrone("qwer-3255-637736-878648", "Lightweight", 20.00f, "IDLE", 98.0f);
            CoreDrone coreDrone2 = new CoreDrone("qwer-54775-88764h-09dfj89", "Middleweight", 30.00f, "IDLE", 98.0f);
            CoreDrone coreDrone3 = new CoreDrone("qwer-98478n-7ejer7-9erur7", "Lightweight", 20.00f, "IDLE", 98.0f);
            CoreDrone coreDrone4 = new CoreDrone("qwer-3255-776fh4-x84b3", "Middleweight", 30.00f, "IDLE", 98.0f);
            CoreDrone coreDrone5 = new CoreDrone("qwer-3255-6r5bbfi-84trbu", "Heavyweight", 100.00f, "IDLE", 98.0f);
            CoreDrone coreDrone6 = new CoreDrone("qwer-757fh76-47rb773-63gr8u", "Cruiserweight", 50.00f, "IDLE", 98.0f);

            coreDrone1 = coreDroneService.saveOrUpdateFlush(coreDrone1);
            coreDrone2 = coreDroneService.saveOrUpdateFlush(coreDrone2);
            coreDrone3 = coreDroneService.saveOrUpdateFlush(coreDrone3);
            coreDrone4 = coreDroneService.saveOrUpdateFlush(coreDrone4);
            coreDrone5 = coreDroneService.saveOrUpdateFlush(coreDrone5);
            coreDrone6 = coreDroneService.saveOrUpdateFlush(coreDrone6);

            CoreDroneActivity coreDroneActivity1 = new CoreDroneActivity(coreDrone1, "Newly Created Drone", "");
            CoreDroneActivity coreDroneActivity2 = new CoreDroneActivity(coreDrone2, "Newly Created Drone", "");
            CoreDroneActivity coreDroneActivity3 = new CoreDroneActivity(coreDrone3, "Newly Created Drone", "");
            CoreDroneActivity coreDroneActivity4 = new CoreDroneActivity(coreDrone4, "Newly Created Drone", "");
            CoreDroneActivity coreDroneActivity5 = new CoreDroneActivity(coreDrone5, "Newly Created Drone", "");
            CoreDroneActivity coreDroneActivity6 = new CoreDroneActivity(coreDrone6, "Newly Created Drone", "");

            coreDroneService.saveOrUpdateFlush(coreDroneActivity1);
            coreDroneService.saveOrUpdateFlush(coreDroneActivity2);
            coreDroneService.saveOrUpdateFlush(coreDroneActivity3);
            coreDroneService.saveOrUpdateFlush(coreDroneActivity4);
            coreDroneService.saveOrUpdateFlush(coreDroneActivity5);
            coreDroneService.saveOrUpdateFlush(coreDroneActivity6);

            CoreMedication coreMedication1 = new CoreMedication("CHLOROQUINE", 5.00f, "RET5-RE553-54745-646_ERTE", "htgsjetgdfbbsmfnn".getBytes(), "JPEG");
            CoreMedication coreMedication2 = new CoreMedication("IBUPROFEN", 4.00f, "RET5-RE553-rw4366-646_ERTE", "htgsjetgdfbbsmfnn".getBytes(), "JPEG");
            CoreMedication coreMedication3 = new CoreMedication("TATAMUS", 6.00f, "RET5-ERW734-rw4366-646_ERTE", "htgsjetgdfbbsmfnn".getBytes(), "JPEG");
            CoreMedication coreMedication4 = new CoreMedication("PARACETAMOL", 8.00f, "RET5-PON453-rw4366-646_ERTE", "htgsjetgdfbbsmfnn".getBytes(), "JPEG");

            coreMedication1 = coreMedicationService.saveOrUpdateFlush(coreMedication1);
            coreMedication2 = coreMedicationService.saveOrUpdateFlush(coreMedication2);
            coreMedication3 = coreMedicationService.saveOrUpdateFlush(coreMedication3);
            coreMedication4 = coreMedicationService.saveOrUpdateFlush(coreMedication4);

            CoreDroneTrip coreDroneTrip = new CoreDroneTrip("errttw-0893873-27hgd73-7622","6° 30 7.9416", 656l, coreDrone1.getId(), "LOADED");

            coreDroneTrip = coreDroneService.saveOrUpdateFlush(coreDroneTrip);

            CoreMedicationDrone coreMedicationDrone = new CoreMedicationDrone(coreMedication1, 1, coreDroneTrip);

            coreDroneService.saveOrUpdateFlush(coreMedicationDrone);
        };
    }
}
