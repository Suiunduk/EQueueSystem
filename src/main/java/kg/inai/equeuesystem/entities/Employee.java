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
@Table(name = "employee")
@Entity
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "employee_id")
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

    @Column(name = "address")
    String address;

    @Column(name = "profile_photo")
    String profile_photo;

    @Column(name = "description")
    String description;

    @Column(name = "isAdmin")
    Boolean isAdmin;

    @Column(name = "isLiveQueue")
    Boolean isLiveQueue;

    @ManyToOne
    @JoinColumn(name = "department_id")
    Department department;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne
    @JoinColumn(name = "region_id")
    Region region;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}
