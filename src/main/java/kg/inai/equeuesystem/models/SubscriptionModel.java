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
public class SubscriptionModel {
    Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    Date date;

    String description;

    Long employee_id;

    EmployeeModel employeeModel;
}
