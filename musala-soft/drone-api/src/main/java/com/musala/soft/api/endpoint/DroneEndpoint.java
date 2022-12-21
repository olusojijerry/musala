package com.musala.soft.api.endpoint;

import com.musala.soft.api.dto.DroneDto;
import com.musala.soft.api.services.DroneService;
import com.musala.soft.entity.drones.CoreDrone;
import com.musala.soft.entity.drones.CoreDroneActivity;
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


}
