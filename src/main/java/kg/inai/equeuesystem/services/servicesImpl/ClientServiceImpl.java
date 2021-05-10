package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.Client;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.ClientModel;
import kg.inai.equeuesystem.repositories.ClientRepository;
import kg.inai.equeuesystem.services.ClientService;
import kg.inai.equeuesystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserService userService;

    @Override
    public Client create(ClientModel clientModel) {
        Client client = Client.builder()
                .registration_date(clientModel.getRegistration_date())
                .name(clientModel.getName())
                .surname(clientModel.getSurname())
                .middle_name(clientModel.getMiddle_name())
                .pin(clientModel.getPin())
                .phone_number(clientModel.getPhone_number())
                .work_address(clientModel.getWork_address())
                .description(clientModel.getDescription())
                .user(userService.create(clientModel.getUserModel()))
                .build();
        return clientRepository.save(client);
    }

    @Override
    public Client update(ClientModel clientModel) {
        return clientRepository.findById(clientModel.getId())
                .map(newClient -> {
                    newClient.setRegistration_date(clientModel.getRegistration_date());
                    newClient.setName(clientModel.getName());
                    newClient.setSurname(clientModel.getSurname());
                    newClient.setMiddle_name(clientModel.getMiddle_name());
                    newClient.setPin(clientModel.getPin());
                    newClient.setPhone_number(clientModel.getPhone_number());
                    newClient.setWork_address(clientModel.getWork_address());
                    newClient.setDescription(clientModel.getDescription());
                    newClient.setUser(userService.update(clientModel.getUserModel()));
                    return clientRepository.save(newClient);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + clientModel.getId()));
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id).get();
    }
}
