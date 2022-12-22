package com.musala.soft.api.services;

import com.musala.soft.api.dto.*;
import com.musala.soft.api.utils.Util;
import com.musala.soft.entity.drones.*;
import com.musala.soft.entity.enumeration.ModelEnum;
import com.musala.soft.entity.enumeration.StatusEnum;
import com.musala.soft.repo.services.CoreDroneService;
import com.musala.soft.repo.services.CoreMedicationService;
import com.musala.soft.resources.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class DroneService {
    @Autowired
    CoreDroneService coreDroneService;
    @Autowired
    CoreMedicationService coreMedicationService;

    public CoreDrone createDrone(DroneDto droneDto){
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String serialNumber = sdf.format(new Date());

//        serialNumber = serialNumber + "-" + Util.getUniqueIdentifier();

        ModelEnum modelEnum = ModelEnum.getEnumFromString(droneDto.getModel());
        StatusEnum statusEnum = StatusEnum.getEnumFromString(droneDto.getState());

        CoreDrone coreDrone = new CoreDrone();

        coreDrone.setCreatedDt(new Date());
        coreDrone.setBatteryCapacity(100f);
        coreDrone.setStatus(statusEnum.getValue());
        coreDrone.setSerialNumber(droneDto.getSerial());
        coreDrone.setModel(modelEnum.getValue(modelEnum));
        coreDrone.setWeight(droneDto.getWeight());

        coreDrone = coreDroneService.saveOrUpdate(coreDrone);

        CoreDroneActivity coreDroneActivity = new CoreDroneActivity();

        coreDroneActivity.setDroneSerial(coreDrone.getSerialNumber());
        coreDroneActivity.setCreatedDt(new Date());
        coreDroneActivity.setStatus(statusEnum.getValue());
        coreDroneActivity.setAction("Newly Created Drone");
        coreDroneActivity.setBatteryCapacity(100f);

        coreDroneService.saveOrUpdate(coreDroneActivity);

        return coreDrone;

    }

    public List<CoreDroneActivity> getAllDronesActivity(String droneSerial){
        return coreDroneService.findAllActivityByDroneId(droneSerial);
    }

    @Transactional
    public DroneMedResponse loadDroneWithMedications(LoadDroneWithMed droneWithMed){
        //check if drone exist
        CoreDrone coreDrone = coreDroneService.findDroneWithSerialNumber(droneWithMed.getAvailableDroneCode())
                .orElseThrow(() -> new ApiException("No drone exist with the serial number " + droneWithMed.getAvailableDroneCode()));

        if(!coreDrone.getStatus().equalsIgnoreCase(StatusEnum.IDLE.getValue())){
            throw new ApiException("Drone " + coreDrone.getSerialNumber() + " is currently unavailable for delivery");
        }

        if(coreDrone.getBatteryCapacity() <= 25f){
            throw new ApiException("Power less than or equal 25 percent");
        }
        //Genrate trip id
        String tripId = Util.getUniqueIdentifier();

        CoreDroneTrip coreDroneTrip = new CoreDroneTrip();

        coreDroneTrip.setDroneId(coreDrone.getId());
        coreDroneTrip.setTripId(tripId);
        coreDroneTrip.setCreatedDt(new Date());
        coreDroneTrip.setDestination(droneWithMed.getDestination());
        coreDroneTrip.setDistance(droneWithMed.getDistance());
        coreDroneTrip.setStatus(StatusEnum.LOADING.getValue());

        coreDroneTrip = coreDroneService.saveOrUpdate(coreDroneTrip);

        Float totalWeight = 0f;

        List<CoreMedicationDrone> medicationDrones = new ArrayList<>();

        for(MedToBeLoaded tp : droneWithMed.getMedsToBeLoaded()){
            CoreMedicationDrone coreMedicationDrone = new CoreMedicationDrone();

            CoreMedication coreMedication = coreMedicationService.findByCode(tp.getMedicationCode())
                    .orElseThrow(() -> new ApiException("Medication does not exist with code " + tp.getMedicationCode()));

            coreMedicationDrone.setMedicationId(coreMedication.getId());
            coreMedicationDrone.setStatus(StatusEnum.LOADING.getValue());
            coreMedicationDrone.setQuantity(tp.getQuantity());
            coreMedicationDrone.setCreatedDt(new Date());
            coreMedicationDrone.setCoreDroneTrip(coreDroneTrip);

            totalWeight += coreMedication.getWeight() * tp.getQuantity();

            if(totalWeight >= coreDrone.getWeight()){
                throw new ApiException("Overloading of drone total weight cannot be more or equal to " + coreDrone.getWeight());
            }

            coreDroneService.saveOrUpdate(coreMedicationDrone);
        }

        CoreDroneActivity coreDroneActivity = new CoreDroneActivity();

        coreDroneActivity.setDroneSerial(coreDrone.getSerialNumber());
        coreDroneActivity.setCreatedDt(new Date());
        coreDroneActivity.setAction("Delivery for " + tripId);
        coreDroneActivity.setDestination(droneWithMed.getDestination());
        coreDroneActivity.setStatus(StatusEnum.LOADING.getValue());
        coreDroneActivity.setBatteryCapacity(coreDrone.getBatteryCapacity());

        coreDroneService.saveOrUpdate(coreDroneActivity);

        //Update drone status to loaded
        coreDrone.setStatus(StatusEnum.LOADING.getValue());
        coreDrone.setLastActivityDt(new Date());
        coreDroneService.saveOrUpdate(coreDrone);

        return mapDroneMedResponse(droneWithMed.getMedsToBeLoaded(), coreDroneTrip, coreDrone.getSerialNumber(),
                totalWeight);
    }

    private DroneMedResponse mapDroneMedResponse(List<MedToBeLoaded> lst, CoreDroneTrip trip, String droneCode,
                                                 Float totalWeight){
        DroneMedResponse response = new DroneMedResponse();

        response.setDroneCode(droneCode);
        response.setDestination(trip.getDestination());
        response.setTotalWeight(totalWeight);
        response.setTripId(trip.getTripId());
        response.setMedsToBeLoaded(lst);

        return response;
    }

    public CoreDroneTrip getCurrentDrone(String droneSerial){
        CoreDrone coreDrone = coreDroneService.findDroneWithSerialNumber(droneSerial)
                .orElseThrow(()-> new ApiException("No drone exist with serial " + droneSerial));

        return coreDroneService.findByStatusAndDroneId(StatusEnum.LOADED.getValue(), coreDrone.getId())
                .orElseThrow(()-> new ApiException("No trip found for drone with serial " + droneSerial + " with status LOADED"));
    }

    public CoreDrone updateDroneStatus(SetDroneStatus setDroneStatus){
        CoreDrone coreDrone = coreDroneService.findDroneWithSerialNumber(setDroneStatus.getSerialNumber())
                .orElseThrow(()-> new ApiException("No drone exist with serial " + setDroneStatus.getSerialNumber()));

        StatusEnum statusEnum = StatusEnum.getEnumFromString(setDroneStatus.getStatus());

        switch(statusEnum){
            case LOADED:
              if(!coreDrone.getStatus().equalsIgnoreCase(StatusEnum.LOADING.getValue())){
                  throw new ApiException("Drone must be in the status of LOADING to set it to LOADED");
              }
              CoreDroneTrip coreDroneTrip =  coreDroneService.findByStatusAndDroneId(StatusEnum.LOADING.getValue(), coreDrone.getId())
                        .orElseThrow(()-> new ApiException("No trip found for drone with serial " +
                                setDroneStatus.getSerialNumber() + " with status LOADED"));

              coreDroneTrip.setStatus(statusEnum.getValue());
              coreDroneTrip.setLastActivityDt(new Date());

              coreDroneService.saveOrUpdate(coreDroneTrip);
              break;
            case DELIVERING:
                if(!coreDrone.getStatus().equalsIgnoreCase(StatusEnum.LOADED.getValue())){
                    throw new ApiException("Drone must be in the status of LOADING to set it to LOADED");
                }
                CoreDroneTrip coreDroneTripL =  coreDroneService.findByStatusAndDroneId(StatusEnum.LOADED.getValue(), coreDrone.getId())
                        .orElseThrow(()-> new ApiException("No trip found for drone with serial " +
                                setDroneStatus.getSerialNumber() + " with status LOADED"));

                coreDroneTripL.setStatus(statusEnum.getValue());
                coreDroneTripL.setLastActivityDt(new Date());

                coreDroneService.saveOrUpdate(coreDroneTripL);
                break;
            case DELIVERED:
                if(!coreDrone.getStatus().equalsIgnoreCase(StatusEnum.DELIVERING.getValue())){
                    throw new ApiException("Drone must be in the status of LOADING to set it to LOADED");
                }
                CoreDroneTrip coreDroneTripD =  coreDroneService.findByStatusAndDroneId(StatusEnum.DELIVERING.getValue(), coreDrone.getId())
                        .orElseThrow(()-> new ApiException("No trip found for drone with serial " +
                                setDroneStatus.getSerialNumber() + " with status LOADED"));

                coreDroneTripD.setStatus(statusEnum.getValue());
                coreDroneTripD.setLastActivityDt(new Date());

                coreDroneService.saveOrUpdate(coreDroneTripD);
                break;
            case RETURNING:
                if(!coreDrone.getStatus().equalsIgnoreCase(StatusEnum.DELIVERED.getValue())){
                    throw new ApiException("Drone must be in the status of LOADING to set it to LOADED");
                }
                CoreDroneTrip coreDroneTripR =  coreDroneService.findByStatusAndDroneId(StatusEnum.DELIVERED.getValue(), coreDrone.getId())
                        .orElseThrow(()-> new ApiException("No trip found for drone with serial " +
                                setDroneStatus.getSerialNumber() + " with status LOADED"));

                coreDroneTripR.setStatus(statusEnum.getValue());
                coreDroneTripR.setLastActivityDt(new Date());

                coreDroneService.saveOrUpdate(coreDroneTripR);
                break;
            case IDLE:
                if(!coreDrone.getStatus().equalsIgnoreCase(StatusEnum.RETURNING.getValue())){
                    throw new ApiException("Drone must be in the status of LOADING to set it to LOADED");
                }
                CoreDroneTrip coreDroneTripI =  coreDroneService.findByStatusAndDroneId(StatusEnum.RETURNING.getValue(), coreDrone.getId())
                        .orElseThrow(()-> new ApiException("No trip found for drone with serial " +
                                setDroneStatus.getSerialNumber() + " with status LOADED"));

                coreDroneTripI.setStatus(statusEnum.getValue());
                coreDroneTripI.setLastActivityDt(new Date());

                coreDroneService.saveOrUpdate(coreDroneTripI);
                break;
            default:
                throw new ApiException("Invalid update status");
        }

        coreDrone.setStatus(statusEnum.getValue());
        coreDrone.setLastActivityDt(new Date());

        return coreDroneService.saveOrUpdate(coreDrone);
    }

    public List<CoreDrone> getAllAvailableDrones(){
        return coreDroneService.findAllDronesByStatus(StatusEnum.IDLE.getValue());
    }

    public String batteryLevel(String serialNumber){
        CoreDrone coreDrone = coreDroneService.findDroneWithSerialNumber(serialNumber)
                .orElseThrow(() -> new ApiException("No drone exist with serial " + serialNumber));

        Float batterylevel = coreDrone.getBatteryCapacity();

        return batterylevel.toString();
    }
}
