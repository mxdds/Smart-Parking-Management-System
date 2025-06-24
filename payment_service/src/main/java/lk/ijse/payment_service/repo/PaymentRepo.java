package lk.ijse.payment_service.repo;

import lk.ijse.payment_service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

        Payment findByUserId(String userId);
        Payment findByVehicleId(String vehicleId);
//    Payment findByUserIdAndVehicleId(String userId, String vehicleId);
//    Payment findByUserIdAndVehicleIdAndStatus(String userId, String vehicleId, String status);



    }