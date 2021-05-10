package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.QueueScheduled;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.QueueScheduledModel;
import kg.inai.equeuesystem.repositories.QueueScheduledRepository;
import kg.inai.equeuesystem.services.ClientService;
import kg.inai.equeuesystem.services.EmployeeService;
import kg.inai.equeuesystem.services.QueueScheduledService;
import kg.inai.equeuesystem.services.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueScheduledServiceImpl implements QueueScheduledService {
    @Autowired
    private QueueScheduledRepository queueScheduledRepository;

    @Autowired
    private TimetableService timetableService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ClientService clientService;

    @Override
    public QueueScheduled create(QueueScheduledModel queueScheduledModel) {
        QueueScheduled queueScheduled = QueueScheduled.builder()
                .registration_date(queueScheduledModel.getRegistration_date())
                .client_full_name(queueScheduledModel.getClient_full_name())
                .client_phone_number(queueScheduledModel.getClient_phone_number())
                .is_redirected(queueScheduledModel.getIs_redirected())
                .redirect_employee(employeeService.create(queueScheduledModel.getRedirect_employee()))
                .description(queueScheduledModel.getDescription())
                .status(queueScheduledModel.getStatus())
                .client(clientService.create(queueScheduledModel.getClientModel()))
                .timetable(timetableService.create(queueScheduledModel.getTimetableModel()))
                .build();
        return queueScheduledRepository.save(queueScheduled);
    }

    @Override
    public QueueScheduled update(QueueScheduledModel queueScheduledModel) {
        return queueScheduledRepository.findById(queueScheduledModel.getId())
                .map(newQueueScheduled -> {
                    newQueueScheduled.setRegistration_date(queueScheduledModel.getRegistration_date());
                    newQueueScheduled.setClient_full_name(queueScheduledModel.getClient_full_name());
                    newQueueScheduled.setClient_phone_number(queueScheduledModel.getClient_phone_number());
                    newQueueScheduled.setIs_redirected(queueScheduledModel.getIs_redirected());
                    newQueueScheduled.setRedirect_employee(employeeService.update(queueScheduledModel.getRedirect_employee()));
                    newQueueScheduled.setDescription(queueScheduledModel.getDescription());
                    newQueueScheduled.setStatus(queueScheduledModel.getStatus());
                    newQueueScheduled.setClient(clientService.update(queueScheduledModel.getClientModel()));
                    newQueueScheduled.setTimetable(timetableService.update(queueScheduledModel.getTimetableModel()));
                    return queueScheduledRepository.save(newQueueScheduled);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + queueScheduledModel.getId()));
    }

    @Override
    public List<QueueScheduled> findAll() {
        return queueScheduledRepository.findAll();
    }

    @Override
    public QueueScheduled getById(Long id) {
        return queueScheduledRepository.getOne(id);
    }
}
