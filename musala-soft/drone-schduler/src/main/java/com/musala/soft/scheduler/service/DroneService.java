package com.musala.soft.scheduler.service;

import com.musala.soft.entity.drones.CoreDrone;
import com.musala.soft.repo.services.CoreDroneService;
import com.musala.soft.scheduler.Wrapper.CoreDroneWrapper;
import com.musala.soft.scheduler.Wrapper.RestResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class DroneService {
    @Autowired
    CoreDroneService coreDroneService;
    @Autowired
    private WebClient.Builder webclient;

    public List<CoreDrone> getAllDrones(){
        return coreDroneService.findAll();
    }

    public CoreDrone updateDroneStatus(CoreDrone coreDrone, Float batteryLevel){
        coreDrone.setBatteryCapacity(batteryLevel);

        return coreDroneService.saveOrUpdate(coreDrone);
    }

    public List<Map<String, Object>> getAllDronesClient(){
//        String str = "localhost:9000/";
//        webclient = webclient.baseUrl(str);

        return (List<Map<String, Object>>) webclient.build().get().uri("localhost:9000/api/drone/all")
                .retrieve().bodyToMono(RestResponseWrapper.class).block().getData();
    }

    public String updateDroneStatus(CoreDrone coreDrone){
        CoreDroneWrapper coreDroneWrapper = new CoreDroneWrapper(coreDrone.getId(), coreDrone.getSerialNumber(),
                coreDrone.getModel(), coreDrone.getWeight(), coreDrone.getBatteryCapacity(), coreDrone.getStatus());

        RestResponseWrapper restResponseWrapper = webclient.build()
                .put()
                .uri("localhost:9000/api/drone/battery")
                .body(BodyInserters.fromValue(coreDroneWrapper))
                .retrieve()
                .bodyToMono(RestResponseWrapper.class).block();

        Map<String, Object> map = (Map<String, Object>) restResponseWrapper.getData();

        return (String) map.get("serialNumber");
    }
}
