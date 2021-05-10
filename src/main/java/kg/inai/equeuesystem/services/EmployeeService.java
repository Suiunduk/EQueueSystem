package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.Employee;
import kg.inai.equeuesystem.models.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    Employee create(EmployeeModel employeeModel);
    Employee update(EmployeeModel employeeModel);
    List<Employee> findAll();
    Employee getById(Long id);
}
