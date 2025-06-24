package lk.ijse.payment_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Payment {

        @Id
        @GeneratedValue
        private Long id;
        private String cardNumber;
        private double amount;
        private String status;
        private LocalDateTime timestamp;
        private String vehicleId; // Added missing property

        // Uncomment if you need userId as well
        private String userId;

        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }

        // Add getter and setter for vehicleId
        public String getVehicleId() { return vehicleId; }
        public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

        public Payment() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        // Updated constructor to include vehicleId and userId
        public Payment(Long id, String cardNumber, double amount, String status, LocalDateTime timestamp,
                       String vehicleId, String userId) {
            this.id = id;
            this.cardNumber = cardNumber;
            this.amount = amount;
            this.status = status;
            this.timestamp = timestamp;
            this.vehicleId = vehicleId;
            this.userId = userId;
        }
    }
