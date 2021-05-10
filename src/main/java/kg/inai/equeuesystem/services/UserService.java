package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.User;
import kg.inai.equeuesystem.models.UserModel;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User create(UserModel userModel);

    User update(UserModel userModel);

    User getById(Long id);
}
