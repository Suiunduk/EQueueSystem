package kg.inai.equeuesystem.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "region")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Region {
    @Id
    @GeneratedValue
    @Column(name = "region_id")
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id")
    Country country;
}
