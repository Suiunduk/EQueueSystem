package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.Organization;
import kg.inai.equeuesystem.models.OrganizationModel;

import java.util.List;

public interface OrganizationService {
    Organization create(OrganizationModel organizationModel);
    Organization update(OrganizationModel organizationModel);
    List<Organization> findAll();
    Organization getById(Long id);
}
