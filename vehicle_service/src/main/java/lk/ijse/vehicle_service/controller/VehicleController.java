package lk.ijse.vehicle_service.controller;

import lk.ijse.vehicle_service.entity.Vehicle;
import lk.ijse.vehicle_service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {


    @Autowired
    private VehicleService service;

    @GetMapping("/user/{userId}")
    public List<Vehicle> byUser(@PathVariable String userId) {
        return service.vehicleRepo.findByUserId(userId);
    }

    @PostMapping("/register")
    public Vehicle register(@RequestBody Vehicle v) {
        return service.register(v);
    }

    @PutMapping("/enter/{id}")
    public Vehicle enter(@PathVariable Long id) {
        return service.simulateEntity(id);
    }

    @PutMapping("/exit/{id}")
    public Vehicle exit(@PathVariable Long id) {
        return service.simulateExit(id);
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.vehicleRepo.deleteById(id);
        return "Vehicle deleted successfully.";
    }
    @PostMapping("/update/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle updated) {
        return service.update(id, updated);
    }
    //    Link vehicle to users
    @GetMapping("/all")
    public List<Vehicle> all() {
        return service.vehicleRepo.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle get(@PathVariable Long id) {
        return service.vehicleRepo.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }





}