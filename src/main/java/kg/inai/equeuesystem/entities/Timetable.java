package kg.inai.equeuesystem.entities;

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
@Table(name = "timetable")
@Entity
public class Timetable {
    @Id
    @GeneratedValue
    @Column(name = "timetable_id")
    Long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    @Column(name = "beginning_time", nullable = false)
    Date beginning_time;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm")
    @Column(name = "end_time", nullable = false)
    Date end_time;

    @Column(name = "duration")
    Integer duration;

    @Column(name = "description")
    String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "day", nullable = false)
    TimetableDay day;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    Employee employee;
}
