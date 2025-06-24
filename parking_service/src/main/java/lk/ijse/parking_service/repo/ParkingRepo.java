package lk.ijse.parking_service.repo;

import lk.ijse.parking_service.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepo extends JpaRepository<Parking, Long> {

    List<Parking> findByAvailableTrue();

    List<Parking> findByLocation(String location);

    List<Parking> findByAvailable(boolean available);

    List<Parking> findByLocationAndAvailable(String location, boolean available);

}