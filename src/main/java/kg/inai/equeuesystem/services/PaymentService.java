package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.Payment;
import kg.inai.equeuesystem.models.PaymentModel;

import java.util.List;

public interface PaymentService {
    Payment create(PaymentModel paymentModel);
    Payment update(PaymentModel paymentModel);
    List<Payment> findAll();
    Payment getById(Long id);
}
