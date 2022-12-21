package com.musala.soft.repo.services;

import com.musala.soft.entity.drones.CoreDrone;
import com.musala.soft.entity.drones.CoreDroneActivity;
import com.musala.soft.entity.drones.CoreDroneTrip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CoreDroneService {
    CoreDrone saveOrUpdate(CoreDrone coreDrone);
    Optional<CoreDrone> findById(Long id);
    Page<CoreDrone> findAll(String serialNumber, Float batteryCapacity, Pageable pageable);
    CoreDroneActivity saveOrUpdate(CoreDroneActivity coreDroneActivity);
    List<CoreDroneActivity> findAllActivityByDroneId(String droneSerial);
    CoreDroneTrip saveOrUpdate(CoreDroneTrip coreDroneTrip);
    List<CoreDroneTrip> findAllDroneTrips(String serialNumber);
    List<CoreDroneTrip> findAllTripByByDateRange(Date fromDate, Date toDate);
    Long getTotalCountOfDroneByDate(String date);

//    List<CoreDrone> findByStatus(String status);
//    List<CoreDrone> findAll();
}
