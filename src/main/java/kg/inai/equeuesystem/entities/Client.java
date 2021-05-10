package kg.inai.equeuesystem.entities;

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
@Table(name = "client")
@Entity
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "client_id")
    Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    @Column(name = "registration_date", nullable = false)
    Date registration_date;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "middle_name")
    String middle_name;

    @Column(name = "pin")
    String pin;

    @Column(name = "phone_number")
    String phone_number;

    @Column(name = "work_address")
    String work_address;

    @Column(name = "description")
    String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}