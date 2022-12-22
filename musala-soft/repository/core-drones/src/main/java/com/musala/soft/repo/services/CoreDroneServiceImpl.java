package com.musala.soft.repo.services;

import com.musala.soft.entity.drones.CoreDrone;
import com.musala.soft.entity.drones.CoreDroneActivity;
import com.musala.soft.entity.drones.CoreDroneTrip;
import com.musala.soft.entity.drones.CoreMedicationDrone;
import com.musala.soft.repo.repository.CoreDroneActivityRepository;
import com.musala.soft.repo.repository.CoreDroneMedicationRepository;
import com.musala.soft.repo.repository.CoreDroneRepository;
import com.musala.soft.repo.repository.CoreDroneTripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CoreDroneServiceImpl implements CoreDroneService {
    @Autowired
    CoreDroneRepository coreDroneRepository;
    @Autowired
    CoreDroneActivityRepository coreDroneActivityRepository;
    @Autowired
    CoreDroneTripRepository coreDroneTripRepository;
    @Autowired
    CoreDroneMedicationRepository coreDroneMedicationRepository;
    @Override
    public CoreDrone saveOrUpdate(CoreDrone coreDrone) {
        return coreDroneRepository.save(coreDrone);
    }

    @Override
    public Optional<CoreDrone> findDroneWithSerialNumber(String serialNumber) {
        return coreDroneRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public Optional<CoreDrone> findById(Long id) {
        return coreDroneRepository.findById(id);
    }

    @Override
    public Page<CoreDrone> findAll(String serialNumber, Float batteryCapacity, Pageable pageable) {
        return coreDroneRepository.findAll(pageable);
    }

    @Override
    public CoreDroneActivity saveOrUpdate(CoreDroneActivity coreDroneActivity) {
        return coreDroneActivityRepository.save(coreDroneActivity);
    }

    @Override
    public List<CoreDroneActivity> findAllActivityByDroneId(String droneSerail) {
        return coreDroneActivityRepository.findAllByDroneSerial(droneSerail);
    }

    @Override
    public CoreDroneTrip saveOrUpdate(CoreDroneTrip coreDroneTrip) {
        return coreDroneTripRepository.save(coreDroneTrip);
    }

    @Override
    public List<CoreDroneTrip> findAllDroneTrips(String serialNumber) {
        return new ArrayList<>();//coreDroneTripRepository.getAllDroneTripBySerialNumber(serialNumber);
    }

    @Override
    public List<CoreDroneTrip> findAllTripByByDateRange(Date fromDate, Date toDate) {
        return new ArrayList<>();//coreDroneTripRepository.getAllDroneTripByDate(fromDate, toDate);
    }

    @Override
    public Long getTotalCountOfDroneByDate(String date) {
        return 1L;
    }

    @Override
    public CoreMedicationDrone saveOrUpdate(CoreMedicationDrone coreMedicationDrone) {
        return coreDroneMedicationRepository.save(coreMedicationDrone);
    }

    @Override
    public CoreDroneTrip findDroneTripByTripId(String tripId) {
        return null;
    }

    @Override
    public Optional<CoreDroneTrip> findByStatusAndDroneId(String status, Long droneId) {
        return coreDroneTripRepository.findByStatusAndDroneId(status, droneId);
    }

    @Override
    public List<CoreDrone> findAllDronesByStatus(String status) {
        return coreDroneRepository.findByStatus(status);
    }

//    @Override
//    public List<CoreDrone> findByStatus(String status) {
//        return null;
//    }
//
//    @Override
//    public List<CoreDrone> findAll() {
//        return null;
//    }
}
