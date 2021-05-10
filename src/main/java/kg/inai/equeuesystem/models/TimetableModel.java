package kg.inai.equeuesystem.models;

import kg.inai.equeuesystem.enums.TimetableDay;
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
public class TimetableModel {
    Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    Date beginning_time;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    Date end_time;

    Integer duration;

    String description;

    TimetableDay day;

    Long employee_id;

    EmployeeModel employeeModel;
}
