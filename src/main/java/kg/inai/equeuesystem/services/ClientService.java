package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.Client;
import kg.inai.equeuesystem.models.ClientModel;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    Client create(ClientModel clientModel);

    Client update(ClientModel clientModel);

    Client getById(Long id);
}
