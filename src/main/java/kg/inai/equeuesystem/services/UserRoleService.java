package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.UserRole;
import kg.inai.equeuesystem.models.UserRoleModel;

import java.util.List;

public interface UserRoleService {
    UserRole create(UserRoleModel userRoleModel);
    List<UserRole> findAll();
    UserRole update(UserRoleModel userRoleModel);
    UserRole getById(Long id);
    UserRole getUserRoleByName(String name);
}
