package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.User;
import kg.inai.equeuesystem.entities.UserRole;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.UserRoleModel;
import kg.inai.equeuesystem.repositories.UserRoleRepository;
import kg.inai.equeuesystem.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRole create(UserRoleModel userRoleModel) {
        UserRole userRole = UserRole.builder()
                .name(userRoleModel.getName())
                .build();
        return userRoleRepository.save(userRole);
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole update(UserRoleModel userRoleModel) {
        return userRoleRepository.findById(userRoleModel.getId())
                .map(newUserRole -> {
                    newUserRole.setName(userRoleModel.getName());
                    return userRoleRepository.save(newUserRole);
                })
                .orElseThrow(() ->
                        new RecordNotFoundException("Record not found with id:" + userRoleModel.getId()));
    }

    @Override
    public UserRole getById(Long id) {
        return userRoleRepository.getOne(id);
    }

    @Override
    public UserRole getUserRoleByName(String name) {
        return userRoleRepository.getByName(name);
    }
}
