package kg.inai.equeuesystem.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentModel {
    Long id;

    String name;

    OrganizationModel organizationModel;
}
