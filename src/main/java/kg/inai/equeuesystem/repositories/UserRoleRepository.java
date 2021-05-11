package kg.inai.equeuesystem.repositories;

import kg.inai.equeuesystem.entities.Category;
import kg.inai.equeuesystem.entities.User;
import kg.inai.equeuesystem.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository  extends JpaRepository<UserRole, Long> {
    UserRole getByName(String name);
}
