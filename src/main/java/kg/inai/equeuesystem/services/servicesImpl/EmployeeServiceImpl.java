package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.Employee;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.EmployeeModel;
import kg.inai.equeuesystem.repositories.EmployeeRepository;
import kg.inai.equeuesystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RegionService regionService;

    @Override
    public Employee create(EmployeeModel employeeModel) {
        Employee employee = Employee.builder()
                .registration_date(employeeModel.getRegistration_date())
                .name(employeeModel.getName())
                .surname(employeeModel.getSurname())
                .middle_name(employeeModel.getMiddle_name())
                .pin(employeeModel.getPin())
                .phone_number(employeeModel.getPhone_number())
                .address(employeeModel.getAddress())
                .profile_photo(employeeModel.getProfile_photo())
                .description(employeeModel.getDescription())
                .isAdmin(employeeModel.getIsAdmin())
                .isLiveQueue(employeeModel.getIsLiveQueue())
                .department(departmentService.create(employeeModel.getDepartmentModel()))
                .category(categoryService.create(employeeModel.getCategoryModel()))
                .region(regionService.create(employeeModel.getRegionModel()))
                .user(userService.create(employeeModel.getUserModel()))
                .build();
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(EmployeeModel employeeModel) {
        return employeeRepository.findById(employeeModel.getId())
                .map(newEmployee -> {
                    newEmployee.setRegistration_date(employeeModel.getRegistration_date());
                    newEmployee.setName(employeeModel.getName());
                    newEmployee.setSurname(employeeModel.getSurname());
                    newEmployee.setMiddle_name(employeeModel.getMiddle_name());
                    newEmployee.setPin(employeeModel.getPin());
                    newEmployee.setPhone_number(employeeModel.getPhone_number());
                    newEmployee.setAddress(employeeModel.getAddress());
                    newEmployee.setProfile_photo(employeeModel.getProfile_photo());
                    newEmployee.setDescription(employeeModel.getDescription());
                    newEmployee.setIsAdmin(employeeModel.getIsAdmin());
                    newEmployee.setIsLiveQueue(employeeModel.getIsLiveQueue());
                    newEmployee.setDepartment(departmentService.update(employeeModel.getDepartmentModel()));
                    newEmployee.setCategory(categoryService.update(employeeModel.getCategoryModel()));
                    newEmployee.setRegion(regionService.update(employeeModel.getRegionModel()));
                    newEmployee.setUser(userService.update(employeeModel.getUserModel()));
                    return employeeRepository.save(newEmployee);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + employeeModel.getId()));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).get();
    }

}
