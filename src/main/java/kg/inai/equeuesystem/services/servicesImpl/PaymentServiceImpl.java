package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.Payment;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.PaymentModel;
import kg.inai.equeuesystem.repositories.PaymentRepository;
import kg.inai.equeuesystem.services.EmployeeService;
import kg.inai.equeuesystem.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private EmployeeService employeeService;


    @Override
    public Payment create(PaymentModel paymentModel) {
        Payment payment = Payment.builder()
                .amount(paymentModel.getAmount())
                .date(paymentModel.getDate())
                .description(paymentModel.getDescription())
                .bank_service(paymentModel.getBank_service())
                .employee(employeeService.create(paymentModel.getEmployeeModel()))
                .build();
        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(PaymentModel paymentModel) {
        return paymentRepository.findById(paymentModel.getId())
                .map(newPayment -> {
                    newPayment.setAmount(paymentModel.getAmount());
                    newPayment.setDate(paymentModel.getDate());
                    newPayment.setDescription(paymentModel.getDescription());
                    newPayment.setBank_service(paymentModel.getBank_service());
                    newPayment.setEmployee(employeeService.update(paymentModel.getEmployeeModel()));
                    return paymentRepository.save(newPayment);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + paymentModel.getId()));
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(Long id) {
        return paymentRepository.getOne(id);
    }
}
