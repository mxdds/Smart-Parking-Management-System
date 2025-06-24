package lk.ijse.vehicle_service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
    @Id
        @GeneratedValue
        private Long id;
        private String licensePlate;
        private String type;
        private String userId;
        private boolean inside;

        public Vehicle() {
        }

        public Vehicle(Long id, String licensePlate, String type, String userId, boolean inside) {
            this.id = id;
            this.licensePlate = licensePlate;
            this.type = type;
            this.userId = userId;
            this.inside = inside;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getLicensePlate() {
            return licensePlate;
        }

        public void setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public boolean isInside() {
            return inside;
        }

        public void setInside(boolean inside) {
            this.inside =inside;
        }

    }

