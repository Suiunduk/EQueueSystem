package kg.inai.equeuesystem.bootstrap;

import kg.inai.equeuesystem.entities.Client;
import kg.inai.equeuesystem.entities.Employee;
import kg.inai.equeuesystem.entities.User;
import kg.inai.equeuesystem.entities.UserRole;
import kg.inai.equeuesystem.repositories.ClientRepository;
import kg.inai.equeuesystem.repositories.EmployeeRepository;
import kg.inai.equeuesystem.repositories.UserRepository;
import kg.inai.equeuesystem.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        UserRole admin = UserRole.builder()
                .name("SUPER_ADMIN")
                .build();
        userRoleRepository.save(admin);

        UserRole client = UserRole.builder()
                .name("CLIENT")
                .build();
        userRoleRepository.save(client);

        UserRole employee = UserRole.builder()
                .name("EMPLOYEE")
                .build();
        userRoleRepository.save(employee);

        //USERS
        User userAdmin = User.builder()
                .username("admin")
                .email("admin@gmail.com")
                .password(passwordEncoder.encode("123"))
                .isActive(true)
                .userRole(admin)
                .build();
        userRepository.save(userAdmin);

        User userEmployee = User.builder()
                .username("employee")
                .email("employee@gmail.com")
                .password(passwordEncoder.encode("123"))
                .isActive(true)
                .userRole(employee)
                .build();
        userRepository.save(userEmployee);

        User userClient = User.builder()
                .username("client")
                .email("client@gmail.com")
                .password(passwordEncoder.encode("123"))
                .isActive(true)
                .userRole(client)
                .build();
        userRepository.save(userClient);

        //EMPLOYEE
        Employee employeeUser = Employee.builder()
                .name("Employee")
                .surname("Test")
                .pin("123")
                .phone_number("+996700221100")
                .address("Test")
                .user(userEmployee)
                .registration_date(new Date(System.currentTimeMillis()))
                .build();
        employeeRepository.save(employeeUser);

        //CLIENT
        Client clientUser = Client.builder()
                .name("Client")
                .surname("Test")
                .pin("123")
                .phone_number("+996700332211")
                .work_address("Test")
                .user(userClient)
                .registration_date(new Date(System.currentTimeMillis()))
                .build();
        clientRepository.save(clientUser);

    }
}