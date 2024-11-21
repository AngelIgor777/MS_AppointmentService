package org.clinic.ms_appointmentservice.service;


import lombok.RequiredArgsConstructor;
import org.clinic.ms_appointmentservice.entity.Record;
import org.springframework.stereotype.Service;
import org.clinic.ms_appointmentservice.repository.RecordRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final RecordRepository repository;

    public Record findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    /*public Integer getRecordAmountByDoctorId(Long id){
         return repository.getRecordAmountByDoctor_id(id);
    }*/

    public List<Record> getRecordsByDoctorId(Long id){
        return repository.getRecordsByDoctorId(id);
    }
    public Record saveRecord(Record record) {
        return repository.save(record);
    }

    public List<Record> findAll() {
        return (List<Record>) repository.findAll();
    }

    public Record updateRecord(Long id, Record record) throws EntityNotFoundException {
        Optional<Record> oldRecord = repository.findById(id);
        if (oldRecord.isPresent()) {
            record.setId(id);
            repository.save(record);
            return record;
        }
        throw new EntityNotFoundException("Record by id: " + id + ", not found");
    }

    public Long deleteById(Long id){
        repository.deleteById(id);
        return id;
    }
}
