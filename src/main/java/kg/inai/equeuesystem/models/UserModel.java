package kg.inai.equeuesystem.models;

import kg.inai.equeuesystem.enums.UserRole;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserModel {

    Long id;

    UserRole userRole;

    String username;

    String password;

    String email;

    Boolean isActive;
}
