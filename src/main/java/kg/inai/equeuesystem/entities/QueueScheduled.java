package kg.inai.equeuesystem.entities;

import kg.inai.equeuesystem.enums.QueueStatus;
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
@Table(name = "queue_scheduled")
@Entity
public class QueueScheduled {
    @Id
    @GeneratedValue
    @Column(name = "queue_schedule_id")
    Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    @Column(name = "registration_date", nullable = false)
    Date registration_date;

    @Column(name = "client_full_name")
    String client_full_name;

    @Column(name = "client_phone_number")
    String client_phone_number;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    @Column(name = "scheduled_date")
    Date scheduled_date;

    @Column(name = "is_redirected")
    Boolean is_redirected;

    @ManyToOne(optional = true)
    @JoinColumn(name = "redirected_by")
    Employee redirect_employee;

    @Column(name = "description")
    String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    QueueStatus status;

    @ManyToOne(optional = true)
    @JoinColumn(name = "client_id")
    Client client;

    @ManyToOne(optional = true)
    @JoinColumn(name = "timetable_id")
    Timetable timetable;
}
