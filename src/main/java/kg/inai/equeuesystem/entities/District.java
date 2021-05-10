package kg.inai.equeuesystem.entities;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "district")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class District {
    @Id
    @GeneratedValue
    @Column(name = "district_id")
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "isCity")
    Boolean isCity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "region_id")
    Region region;
}
