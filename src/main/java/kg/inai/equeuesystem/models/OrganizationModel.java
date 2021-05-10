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
public class OrganizationModel {
    Long id;

    String name;

    String phone_number;

    String inn;

    CategoryModel categoryModel;
}
