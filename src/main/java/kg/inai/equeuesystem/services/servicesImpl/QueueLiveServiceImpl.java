package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.QueueLive;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.QueueLiveModel;
import kg.inai.equeuesystem.repositories.QueueLiveRepository;
import kg.inai.equeuesystem.services.ClientService;
import kg.inai.equeuesystem.services.EmployeeService;
import kg.inai.equeuesystem.services.QueueLiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueLiveServiceImpl implements QueueLiveService {
    @Autowired
    private QueueLiveRepository queueLiveRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ClientService clientService;

    @Override
    public QueueLive create(QueueLiveModel queueLiveModel) {
        QueueLive queueLive = QueueLive.builder()
                .registration_date(queueLiveModel.getRegistration_date())
                .client_full_name(queueLiveModel.getClient_full_name())
                .client_phone_number(queueLiveModel.getClient_phone_number())
                .is_redirected(queueLiveModel.getIs_redirected())
                .redirect_employee(employeeService.create(queueLiveModel.getRedirect_employee()))
                .description(queueLiveModel.getDescription())
                .queue_number(queueLiveModel.getQueue_number())
                .status(queueLiveModel.getStatus())
                .employee(employeeService.create(queueLiveModel.getEmployeeModel()))
                .client(clientService.create(queueLiveModel.getClientModel()))
                .build();
        return queueLiveRepository.save(queueLive);
    }

    @Override
    public QueueLive update(QueueLiveModel queueLiveModel) {
        return queueLiveRepository.findById(queueLiveModel.getId())
                .map(newQueueLive -> {
                    newQueueLive.setRegistration_date(queueLiveModel.getRegistration_date());
                    newQueueLive.setClient_full_name(queueLiveModel.getClient_full_name());
                    newQueueLive.setClient_phone_number(queueLiveModel.getClient_phone_number());
                    newQueueLive.setIs_redirected(queueLiveModel.getIs_redirected());
                    newQueueLive.setRedirect_employee(employeeService.update(queueLiveModel.getRedirect_employee()));
                    newQueueLive.setDescription(queueLiveModel.getDescription());
                    newQueueLive.setQueue_number(queueLiveModel.getQueue_number());
                    newQueueLive.setStatus(queueLiveModel.getStatus());
                    newQueueLive.setEmployee(employeeService.update(queueLiveModel.getEmployeeModel()));
                    newQueueLive.setClient(clientService.update(queueLiveModel.getClientModel()));
                    return queueLiveRepository.save(newQueueLive);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + queueLiveModel.getId()));
    }

    @Override
    public List<QueueLive> findAll() {
        return queueLiveRepository.findAll();
    }

    @Override
    public QueueLive getById(Long id) {
        return queueLiveRepository.getOne(id);
    }
}
