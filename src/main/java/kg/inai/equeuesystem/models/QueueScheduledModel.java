package kg.inai.equeuesystem.models;

import kg.inai.equeuesystem.enums.QueueStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QueueScheduledModel {
    Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    Date registration_date;

    String client_full_name;

    String client_phone_number;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    Date scheduled_date;

    Boolean is_redirected;

    Long redirect_employee_id;

    EmployeeModel redirect_employee;

    String description;

    QueueStatus status;

    ClientModel clientModel;

    TimetableModel timetableModel;
}
