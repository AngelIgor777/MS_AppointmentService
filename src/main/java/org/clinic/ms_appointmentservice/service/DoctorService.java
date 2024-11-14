package org.clinic.ms_appointmentservice.service;

import lombok.RequiredArgsConstructor;
import org.clinic.ms_appointmentservice.entity.Doctor;
import org.clinic.ms_appointmentservice.entity.Record;
import org.clinic.ms_appointmentservice.entity.Schedule;
import org.springframework.stereotype.Service;
import org.clinic.ms_appointmentservice.repository.DoctorRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository repository;
    private final ScheduleService scheduleService;
    private final RecordService recordService;

    /**
     * Данный метод проверяет возможность записи пользоватлем на текущее время
     * @param doctorId id of record doctor
     * @param recordTime time of new Record
     * @return true if possible record on this time and false if not
     */
    //todo сдлеать лолгику чтобы нельзя было записыываться на 13:01
    public boolean checkTimeAvailability(Long doctorId, LocalTime recordTime) {
        Doctor doctor = findById(doctorId);
        List<LocalTime> timesOfDoctorRecords = findAllTimesOfRecordsByDoctorId(doctorId);
        boolean checkPresentTimeInRecords = findAllTimesOfRecordsByDoctorId(doctorId)
                .stream()
                .anyMatch(localTime -> localTime == recordTime);
        if (checkPresentTimeInRecords) {
            return false;
        }
        if (checkTimeSimilarityWithSchedule(doctor, recordTime)){
            return true;
        }
        return false;
    }

    /***
     *  This method checks whether the record time does not violate the doctor's schedule
     * @param doctor current doctor for record
     * @param recordTime current record time
     * @return true if not violate and false if violate the doctor's schedule
     */
    private  boolean checkTimeSimilarityWithSchedule(Doctor doctor,LocalTime recordTime){
        Map<String, LocalTime> scheduleTimes = scheduleService.getScheduleTimes(doctor.getScheduleId());
        if(!(recordTime.isAfter(scheduleTimes.get("startTime")) && recordTime.isBefore(scheduleTimes.get("endTime")))){
            return false;
        }
        if(recordTime.isAfter(scheduleTimes.get("pauseStart")) && recordTime.isBefore(scheduleTimes.get("pauseEnd"))){
            return false;
        }
        return true;
    }
    private List<LocalTime> findAllTimesOfRecordsByDoctorId(Long id) {
        //Doctor doctor = findById(id);
        List<Record> doctorRecords = recordService.getRecordsByDoctorId(id);
        return doctorRecords.stream().map(Record::getTime).toList();

    }

    public Doctor findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Doctor by id: " + id + ", not found"));
    }


}
