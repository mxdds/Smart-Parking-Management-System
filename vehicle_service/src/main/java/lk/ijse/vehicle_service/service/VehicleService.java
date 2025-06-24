package lk.ijse.vehicle_service.service;

import lk.ijse.vehicle_service.entity.Vehicle;
import lk.ijse.vehicle_service.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    public VehicleRepo vehicleRepo;

    public Vehicle register(Vehicle v){
        return   vehicleRepo.save(v);
    }

    public Vehicle simulateEntity(Long id){
        Vehicle v = vehicleRepo.findById(id).orElseThrow();
        v.setInside(true);
        return vehicleRepo.save(v);

    }

    public Vehicle simulateExit(Long id){
        Vehicle v = vehicleRepo.findById(id).orElseThrow();
        v.setInside(false);
        return vehicleRepo.save(v);
    }

    public Vehicle update(Long id, Vehicle updated){
        return vehicleRepo.findById(id)
                .map(vehicle-> {
                    vehicle.setUserId(updated.getUserId());
                    vehicle.setType(updated.getType());
                    vehicle.setInside(updated.isInside());
                    return  vehicleRepo.save(vehicle);
                })
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

           }
    }

