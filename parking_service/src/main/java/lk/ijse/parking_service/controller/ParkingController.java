package lk.ijse.parking_service.controller;

import lk.ijse.parking_service.entity.Parking;
import lk.ijse.parking_service.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

        @Autowired
        private ParkingService parkingService;

        @GetMapping("/available")
        public List<Parking> available() {
            return parkingService.findAvailableSpots();
        }

        @PostMapping("/reserve/{id}")
        public ResponseEntity<String> reserve(@PathVariable Long id) {
            return parkingService.reserveSpot(id);
        }

        @PostMapping("/add")
        public ResponseEntity<String> addParkingSpot(@RequestBody Parking spot) {
            return parkingService.addParkingSpot(spot);
        }

        @PostMapping("/update/{id}")
        public ResponseEntity<String> updateParkingSpot(@PathVariable Long id, @RequestBody Parking updatedSpot) {
            return parkingService.updateParkingSpot(id, updatedSpot);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteParkingSpot(@PathVariable Long id) {
            return parkingService.deleteParkingSpot(id);
        }
        //List and manage parking spaces
        @GetMapping("/all")
        public List<Parking> all() {
            return parkingService.repo.findAll();
        }
        //    Reserve and release parking spaces
        @GetMapping("/{id}")
        public Parking get(@PathVariable Long id) {
            return parkingService.repo.findById(id).orElseThrow(() -> new RuntimeException("Parking spot not found"));
        }
        //    Update status as occupied or available
        @PutMapping("/update-status/{id}")
        public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestParam boolean available) {
            return parkingService.repo.findById(id)
                    .map(spot -> {
                        spot.setAvailable(available);
                        parkingService.repo.save(spot);
                        return ResponseEntity.ok("Parking spot status updated successfully.");
                    })
                    .orElse(ResponseEntity.status(404).body("Parking spot not found."));
        }

        //    Filter by location
        @GetMapping("/location/{location}")
        public List<Parking> findByLocation(@PathVariable String location) {
            return parkingService.repo.findByLocation(location);
        }
        //    Filter by availability
        @GetMapping("/available/{available}")
        public List<Parking> findByAvailability(@PathVariable boolean available) {
            return parkingService.repo.findByAvailable(available);
        }






    }
