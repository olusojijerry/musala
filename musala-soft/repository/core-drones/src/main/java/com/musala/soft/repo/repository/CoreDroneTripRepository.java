package com.musala.soft.repo.repository;

import com.musala.soft.entity.drones.CoreDroneTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CoreDroneTripRepository extends JpaRepository<CoreDroneTrip, Long> {
    List<CoreDroneTrip> findAllByDroneId(Long droneId);
    CoreDroneTrip findByTripId(String tripId);
    Optional<CoreDroneTrip> findByStatusAndDroneId(String status, Long droneId);
    @Query(value = "select * from drone_trip where createddt between :fromDate and :to", nativeQuery = true)
    List<CoreDroneTrip> findAllByCreatedDt(Date fromDate, Date toDate);

    @Query(value = "SELECT c.* FROM drone_trip c JOIN" +
            " Medication_Drone d on " +
            "d.drone_trip_id = c.id where " +
            "c.status = :status and c.drone_id = :droneId",
            nativeQuery = true)
    CoreDroneTrip findTripByStatusAndDroneId(@Param("status") String status, @Param("droneId") Long droneId);
}
