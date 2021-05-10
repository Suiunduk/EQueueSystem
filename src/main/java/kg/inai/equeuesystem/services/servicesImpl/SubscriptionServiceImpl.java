package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.Payment;
import kg.inai.equeuesystem.entities.Subscription;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.SubscriptionModel;
import kg.inai.equeuesystem.repositories.SubscriptionRepository;
import kg.inai.equeuesystem.services.EmployeeService;
import kg.inai.equeuesystem.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public Subscription create(SubscriptionModel subscriptionModel) {
        Subscription subscription = Subscription.builder()
                .date(subscriptionModel.getDate())
                .description(subscriptionModel.getDescription())
                .employee(employeeService.create(subscriptionModel.getEmployeeModel()))
                .build();
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription update(SubscriptionModel subscriptionModel) {
        return subscriptionRepository.findById(subscriptionModel.getId())
                .map(newSubscription -> {
                    newSubscription.setDate(subscriptionModel.getDate());
                    newSubscription.setDescription(subscriptionModel.getDescription());
                    newSubscription.setEmployee(employeeService.update(subscriptionModel.getEmployeeModel()));
                    return subscriptionRepository.save(newSubscription);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + subscriptionModel.getId()));
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Subscription getById(Long id) {
        return subscriptionRepository.getOne(id);
    }
}
