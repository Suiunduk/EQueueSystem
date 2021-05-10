package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.Department;
import kg.inai.equeuesystem.models.DepartmentModel;

import java.util.List;

public interface DepartmentService {
    Department create(DepartmentModel departmentModel);
    Department update(DepartmentModel departmentModel);
    List<Department> findAll();
    Department getById(Long id);
}
