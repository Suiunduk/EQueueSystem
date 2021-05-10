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
@Table(name = "country")
@Entity
public class Country {
    @Id
    @GeneratedValue
    @Column(name = "country_id")
    Long id;

    @Column(name = "name", nullable = false)
    String name;
}

