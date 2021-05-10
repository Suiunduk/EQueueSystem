package kg.inai.equeuesystem.models;

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

public class PaymentModel {
    Long id;

    Double amount;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    Date date;

    String description;

    String bank_service;

    EmployeeModel employeeModel;
}
