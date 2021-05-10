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
@Table(name = "payment")
@Entity
public class Payment {
    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    Long id;

    @Column(name = "payment_amount", nullable = false)
    Double amount;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "payment_date", nullable = false)
    Date date;

    @Column(name = "description")
    String description;

    @Column(name = "bank_service")
    String bank_service;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    Employee employee;
}
