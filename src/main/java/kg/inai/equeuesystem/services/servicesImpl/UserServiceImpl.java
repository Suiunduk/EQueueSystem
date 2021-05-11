package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.User;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.UserModel;
import kg.inai.equeuesystem.repositories.UserRepository;
import kg.inai.equeuesystem.repositories.UserRoleRepository;
import kg.inai.equeuesystem.services.UserRoleService;
import kg.inai.equeuesystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User create(UserModel userModel) {
        User user = User.builder()
                .username(userModel.getUsername())
                .password(passwordEncoder.encode(userModel.getPassword()))
                .email(userModel.getEmail())
                .userRole(userRoleRepository.getOne(userModel.getUserRoleId()))
                .isActive(true)
                .build();
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User update(UserModel userModel) {
        return userRepository.findById(userModel.getId())
                .map(newUser -> {
                    newUser.setUsername(userModel.getUsername());
                    newUser.setPassword(passwordEncoder.encode(userModel.getPassword()));
                    newUser.setEmail(userModel.getEmail());
                    newUser.setUserRole(userRoleRepository.getOne(userModel.getUserRoleId()));
                    return userRepository.save(newUser);
                })
                .orElseThrow(() ->
                        new RecordNotFoundException("Record not found with id:" + userModel.getId()));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getByUsername(username);
    }
}
