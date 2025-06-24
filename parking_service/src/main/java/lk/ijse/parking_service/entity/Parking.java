package lk.ijse.parking_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Parking {

        @Id
        @GeneratedValue
        private Long id;
        private String location;
        private boolean available;

        public Parking() {
        }

        public Parking(Long id, String location, boolean available) {
            this.id = id;
            this.location = location;
            this.available = available;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

    }
