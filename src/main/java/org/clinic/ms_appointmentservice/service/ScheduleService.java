package org.clinic.ms_appointmentservice.service;

import lombok.RequiredArgsConstructor;
import org.clinic.ms_appointmentservice.entity.Schedule;
import org.clinic.ms_appointmentservice.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository repository;

    public Schedule findById(Long id){
        Optional<Schedule> schedule = repository.findById(id);
        return schedule.orElseThrow(()->
                new EntityNotFoundException("Schedule by id: "+id+", not found"));
    }
    public Map<String, LocalTime> getScheduleTimes(Long id){
        Schedule schedule = findById(id);
        Map<String, LocalTime> timeMap =new HashMap<>();
        timeMap.put("startTime", schedule.getTimeStart());
        timeMap.put("pauseStart", schedule.getPauseStart());
        timeMap.put("pauseEnd", schedule.getPauseEnd());
        timeMap.put("endTime", schedule.getTimeEnd());
        return timeMap;
    }
}
