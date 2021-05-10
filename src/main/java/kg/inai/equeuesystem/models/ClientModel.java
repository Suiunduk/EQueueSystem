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
public class ClientModel {

    Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    Date registration_date;

    String name;

    String surname;

    String middle_name;

    String pin;


    String phone_number;

    String work_address;

    String description;

    Long user_id;

    UserModel userModel;
}