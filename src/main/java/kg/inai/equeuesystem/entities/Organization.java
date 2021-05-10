package kg.inai.equeuesystem.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "organization")
@Entity
public class Organization {
    @Id
    @GeneratedValue
    @Column(name = "organization_id")
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "phone_number")
    String phone_number;

    @Column(name = "inn")
    String inn;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    Category category;
}
