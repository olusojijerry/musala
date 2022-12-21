package com.musala.soft.api.services;

import com.musala.soft.api.dto.DroneDto;
import com.musala.soft.api.utils.Util;
import com.musala.soft.entity.drones.CoreDrone;
import com.musala.soft.entity.drones.CoreDroneActivity;
import com.musala.soft.entity.enumeration.ModelEnum;
import com.musala.soft.entity.enumeration.StatusEnum;
import com.musala.soft.repo.services.CoreDroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DroneService {
    @Autowired
    CoreDroneService coreDroneService;

    public CoreDrone createDrone(DroneDto droneDto){
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String serialNumber = sdf.format(new Date());

        serialNumber = serialNumber + "-" + Util.getUniqueIdentifier();

        ModelEnum modelEnum = ModelEnum.getEnumFromString(droneDto.getModel());
        StatusEnum statusEnum = StatusEnum.getEnumFromString(droneDto.getState());

        CoreDrone coreDrone = new CoreDrone();

        coreDrone.setCreatedDt(new Date());
        coreDrone.setBatteryCapacity(100f);
        coreDrone.setStatus(statusEnum.getValue(statusEnum));
        coreDrone.setSerialNumber(serialNumber);
        coreDrone.setModel(modelEnum.getValue(modelEnum));
        coreDrone.setWeight(droneDto.getWeight());

        coreDrone = coreDroneService.saveOrUpdate(coreDrone);

        CoreDroneActivity coreDroneActivity = new CoreDroneActivity();

        coreDroneActivity.setDroneSerial(coreDrone.getSerialNumber());
        coreDroneActivity.setCreatedDt(new Date());
        coreDroneActivity.setStatus(statusEnum.getValue(statusEnum));
        coreDroneActivity.setAction("Newly Created Drone");
        coreDroneActivity.setBatteryCapacity(100f);

        coreDroneService.saveOrUpdate(coreDroneActivity);

        return coreDrone;

    }

    public List<CoreDroneActivity> getAllDronesActivity(String droneSerial){
        return coreDroneService.findAllActivityByDroneId(droneSerial);
    }
}
