package kg.inai.equeuesystem.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeModel {

    Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    Date registration_date;

    String name;

    String surname;

    String middle_name;

    String pin;

    String phone_number;

    String address;

    String profile_photo;

    String description;

    Boolean isAdmin;

    Boolean isLiveQueue;

    DepartmentModel departmentModel;

    CategoryModel categoryModel;

    RegionModel regionModel;

    Long user_id;

    UserModel userModel;
}
