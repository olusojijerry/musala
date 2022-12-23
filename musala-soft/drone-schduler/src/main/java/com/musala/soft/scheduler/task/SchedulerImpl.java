package com.musala.soft.scheduler.task;

import com.musala.soft.entity.drones.CoreDrone;
import com.musala.soft.scheduler.Wrapper.CoreDroneWrapper;
import com.musala.soft.scheduler.service.DroneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
public class SchedulerImpl implements Scheduler{
    @Autowired
    DroneService droneService;

    @Override
    public void updateDroneStatus() {
        List<Map<String, Object>> coreDrones = droneService.getAllDronesClient();

        for(Map<String, Object> map : coreDrones){
            CoreDrone coreDrone = new CoreDrone();

            Random randomNum = new Random();
            Float ranBatteryLevel = new Float(randomNum.nextInt(100));

            Integer i = (Integer) map.get("id");

            coreDrone.setBatteryCapacity(ranBatteryLevel);
            coreDrone.setSerialNumber((String)map.get("serialNumber"));
            coreDrone.setId(i.longValue());

            String  serial = droneService.updateDroneStatus(coreDrone);
            log.info(String.valueOf("Updated battery capacity for drone with serial " + serial ));
        }
//        coreDrones.stream().forEach(drone -> {
//            Random randomNum = new Random();
//            Float ranBatteryLevel = new Float(randomNum.nextInt(100));
//
//            drone.setBatteryCapacity(ranBatteryLevel);
//
//            drone = droneService.updateDroneStatus(drone);
//            log.info(String.valueOf(drone));
//        });
    }

    @Override
    public void updateStatusofDrones() {

    }
}
