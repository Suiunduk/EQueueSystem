package kg.inai.equeuesystem.bootstrap;

import kg.inai.equeuesystem.entities.User;
import kg.inai.equeuesystem.entities.UserRole;
import kg.inai.equeuesystem.repositories.UserRepository;
import kg.inai.equeuesystem.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRepository userRepository;

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

        User userAdmin = User.builder()
                .username("admin")
                .email("admin@gmail.com")
                .password(passwordEncoder.encode("123"))
                .isActive(true)
                .userRole(admin)
                .build();
        userRepository.save(userAdmin);
    }
}