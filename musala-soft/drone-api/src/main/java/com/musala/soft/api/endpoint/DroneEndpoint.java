package com.musala.soft.api.endpoint;

import com.musala.soft.api.dto.*;
import com.musala.soft.api.services.DroneService;
import com.musala.soft.entity.drones.CoreDrone;
import com.musala.soft.entity.drones.CoreDroneActivity;
import com.musala.soft.entity.drones.CoreDroneTrip;
import com.musala.soft.entity.drones.CoreMedicationDrone;
import com.musala.soft.resources.pojo.RestResponsePojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/drone")
@Slf4j
public class DroneEndpoint {
    @Autowired
    DroneService droneService;

    @PostMapping("")
    public RestResponsePojo<CoreDrone> createDrone(@RequestBody DroneDto droneDto){
        RestResponsePojo<CoreDrone> restResponsePojo = new RestResponsePojo<>();

        restResponsePojo.setMessage("Successful");
        restResponsePojo.setData(droneService.createDrone(droneDto));

        return restResponsePojo;
    }

    @GetMapping("/activity")
    public RestResponsePojo<List<CoreDroneActivity>> getAllActivityForDrone(@RequestParam("droneSerial")String droneSerial){
        RestResponsePojo<List<CoreDroneActivity>> restResponsePojo = new RestResponsePojo<>();

        restResponsePojo.setData(droneService.getAllDronesActivity(droneSerial));
        restResponsePojo.setMessage("Successful");

        return restResponsePojo;
    }

    @PostMapping("/load/drone")
    public RestResponsePojo<?> loadDroneWithMed(@RequestBody LoadDroneWithMed loadDroneWithMed){
        RestResponsePojo<DroneMedResponse> restResponsePojo = new RestResponsePojo<>();

        restResponsePojo.setData(droneService.loadDroneWithMedications(loadDroneWithMed));
        restResponsePojo.setMessage("Successful");

        return restResponsePojo;
    }

    @GetMapping("/check/loaded")
    public RestResponsePojo<List<CoreMedicationDrone>> getTripsAndMedications(@RequestParam(name = "serialNumber")String serialNumber){
        RestResponsePojo<List<CoreMedicationDrone>> restResponsePojo = new RestResponsePojo<>();

        restResponsePojo.setMessage("Successful");
        restResponsePojo.setData(droneService.getCurrentDrone(serialNumber));

        return restResponsePojo;
    }

    @PutMapping("")
    public RestResponsePojo<CoreDrone> setDroneStatus(@RequestBody SetDroneStatus setDroneStatus){
        RestResponsePojo<CoreDrone> restResponsePojo = new RestResponsePojo<>();

        restResponsePojo.setMessage("Successful");
        restResponsePojo.setData(droneService.updateDroneStatus(setDroneStatus));

        return restResponsePojo;
    }

    @GetMapping("/check/available")
    public RestResponsePojo<List<CoreDrone>> getTripsAndMedications(){
        RestResponsePojo restResponsePojo = new RestResponsePojo<>();

        restResponsePojo.setMessage("Successful");
        restResponsePojo.setData(droneService.getAllAvailableDrones());

        return restResponsePojo;
    }

    @GetMapping("/check/battery")
    public RestResponsePojo<String> getBatteryLevel(@RequestParam(name = "serialNumber")String serialNumber){
        RestResponsePojo<String> restResponsePojo = new RestResponsePojo<>();

        restResponsePojo.setData(droneService.batteryLevel(serialNumber) + "%");
        restResponsePojo.setMessage("Successful");

        return restResponsePojo;
    }

    @GetMapping("/all")
    public RestResponsePojo<List<CoreDrone>> getAllDrone(){
        RestResponsePojo<List<CoreDrone>> restResponsePojo = new RestResponsePojo<>();

        restResponsePojo.setMessage("Successful");
        restResponsePojo.setData(droneService.getAll());

        return restResponsePojo;
    }

    @PutMapping("/battery")
    public RestResponsePojo<CoreDrone> updateBatteryLevel(@RequestBody CoreDrone batteryLevel){
        RestResponsePojo<CoreDrone> restResponsePojo = new RestResponsePojo<>();

        restResponsePojo.setData(droneService.updateDroneBattery(batteryLevel));
        restResponsePojo.setMessage("Successful");

        return restResponsePojo;
    }


}
