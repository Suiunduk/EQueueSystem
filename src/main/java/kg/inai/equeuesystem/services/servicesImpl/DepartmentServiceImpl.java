package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.Department;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.DepartmentModel;
import kg.inai.equeuesystem.repositories.DepartmentRepository;
import kg.inai.equeuesystem.services.DepartmentService;
import kg.inai.equeuesystem.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private OrganizationService organizationService;

    @Override
    public Department create(DepartmentModel departmentModel) {
        Department department = Department.builder()
                .name(departmentModel.getName())
                .organization(organizationService.create(departmentModel.getOrganizationModel()))
                .build();
        return departmentRepository.save(department);
    }

    @Override
    public Department update(DepartmentModel departmentModel) {
        return departmentRepository.findById(departmentModel.getId())
                .map(newDepartment -> {
                    newDepartment.setName(departmentModel.getName());
                    newDepartment.setOrganization(organizationService.update(departmentModel.getOrganizationModel()));
                    return departmentRepository.save(newDepartment);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + departmentModel.getId()));
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Long id) {
        return departmentRepository.getOne(id);
    }
}
