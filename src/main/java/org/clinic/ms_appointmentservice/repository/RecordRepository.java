package org.clinic.ms_appointmentservice.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.clinic.ms_appointmentservice.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> getRecordsByDoctorId(Long id);
}
