package lk.ijse.payment_service.service;

import lk.ijse.payment_service.entity.Payment;
import lk.ijse.payment_service.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

        @Autowired
        public PaymentRepo repo;

        public Payment process(Payment p) {
            p.setStatus("SUCCESS");
            p.setTimestamp(LocalDateTime.now());
            return repo.save(p);
        }

        public Payment update(Long id, Payment updated) {
            return repo.findById(id)
                    .map(payment -> {
                        payment.setAmount(updated.getAmount());
                        payment.setStatus(updated.getStatus());
                        payment.setTimestamp(LocalDateTime.now());
                        return repo.save(payment);
                    })
                    .orElseThrow(() -> new RuntimeException("Payment not found"));
        }


        public void deletePayment(Long id) {
            repo.findById(id)
                    .ifPresentOrElse(repo::delete, () -> {
                        throw new RuntimeException("Payment not found");
                    });
        }

        public Payment getById(Long id) {
            return repo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Payment not found"));
        }

        public List<Payment> getAllPayments() {
            List<Payment> payments = repo.findAll();
            if (payments.isEmpty()) {
                throw new RuntimeException("No payments found");
            }
            return payments;
        }
    }