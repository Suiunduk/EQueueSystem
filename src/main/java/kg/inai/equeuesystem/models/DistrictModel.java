package kg.inai.equeuesystem.models;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DistrictModel {
    Long id;

    String name;

    Boolean isCity;

    RegionModel regionModel;
}
