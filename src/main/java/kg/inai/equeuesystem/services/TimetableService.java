package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.Timetable;
import kg.inai.equeuesystem.models.TimetableModel;

import java.util.List;

public interface TimetableService {
    Timetable create(TimetableModel timetableModel);
    Timetable update(TimetableModel timetableModel);
    List<Timetable> findAll();
    Timetable getById(Long id);
}
