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
@Table(name = "organization_category")
@Entity
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    Long id;

    @Column(name = "name", nullable = false)
    String name;
}
