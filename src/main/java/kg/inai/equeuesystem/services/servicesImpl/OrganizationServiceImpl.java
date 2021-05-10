package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.District;
import kg.inai.equeuesystem.entities.Organization;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.OrganizationModel;
import kg.inai.equeuesystem.repositories.DistrictRepository;
import kg.inai.equeuesystem.repositories.OrganizationRepository;
import kg.inai.equeuesystem.services.CategoryService;
import kg.inai.equeuesystem.services.OrganizationService;
import kg.inai.equeuesystem.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public Organization create(OrganizationModel organizationModel) {
        Organization organization = Organization.builder()
                .name(organizationModel.getName())
                .phone_number(organizationModel.getPhone_number())
                .inn(organizationModel.getInn())
                .category(categoryService.create(organizationModel.getCategoryModel()))
                .build();
        return organizationRepository.save(organization);
    }

    @Override
    public Organization update(OrganizationModel organizationModel) {
        return organizationRepository.findById(organizationModel.getId())
                .map(newOrganization -> {
                    newOrganization.setName(organizationModel.getName());
                    newOrganization.setPhone_number(organizationModel.getPhone_number());
                    newOrganization.setInn(organizationModel.getInn());
                    newOrganization.setCategory(categoryService.update(organizationModel.getCategoryModel()));
                    return organizationRepository.save(newOrganization);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + organizationModel.getId()));
    }

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getById(Long id) {
        return organizationRepository.getOne(id);
    }
}
