package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.Timetable;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.TimetableModel;
import kg.inai.equeuesystem.repositories.TimetableRepository;
import kg.inai.equeuesystem.services.EmployeeService;
import kg.inai.equeuesystem.services.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableServiceImpl implements TimetableService {
    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public Timetable create(TimetableModel timetableModel) {
        Timetable timetable = Timetable.builder()
                .beginning_time(timetableModel.getBeginning_time())
                .end_time(timetableModel.getEnd_time())
                .duration(timetableModel.getDuration())
                .description(timetableModel.getDescription())
                .day(timetableModel.getDay())
                .employee(employeeService.create(timetableModel.getEmployeeModel()))
                .build();
        return timetableRepository.save(timetable);
    }

    @Override
    public Timetable update(TimetableModel timetableModel) {
        return timetableRepository.findById(timetableModel.getId())
                .map(newTimetable -> {
                    newTimetable.setBeginning_time(timetableModel.getBeginning_time());
                    newTimetable.setEnd_time(timetableModel.getEnd_time());
                    newTimetable.setDuration(timetableModel.getDuration());
                    newTimetable.setDescription(timetableModel.getDescription());
                    newTimetable.setDay(timetableModel.getDay());
                    newTimetable.setEmployee(employeeService.update(timetableModel.getEmployeeModel()));
                    return timetableRepository.save(newTimetable);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + timetableModel.getId()));
    }

    @Override
    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    @Override
    public Timetable getById(Long id) {
        return timetableRepository.getOne(id);
    }
}
