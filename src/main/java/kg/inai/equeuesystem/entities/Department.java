package kg.inai.equeuesystem.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "department_id")
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "organization_id")
    Organization organization;
}
