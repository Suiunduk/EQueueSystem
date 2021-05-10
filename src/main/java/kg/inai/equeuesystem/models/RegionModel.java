package kg.inai.equeuesystem.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegionModel {
    Long id;

    String name;

    CountryModel countryModel;
}
