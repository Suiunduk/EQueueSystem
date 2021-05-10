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
@Table(name = "subscription")
@Entity
public class Subscription {
    @Id
    @GeneratedValue
    @Column(name = "subscription_id")
    Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "end_date", nullable = false)
    Date date;

    @Column(name = "description")
    String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    Employee employee;
}
