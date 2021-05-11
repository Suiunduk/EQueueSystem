package kg.inai.equeuesystem.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "system_user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_role_id", nullable = false)
    UserRole userRole;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "email")
    String email;

    @Column(name = "isActive")
    Boolean isActive;
}
