package org.clinic.ms_appointmentservice.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.clinic.ms_appointmentservice.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    @Query(
            nativeQuery = true,
            value = "select * from ms_record_sc.records r join ms_doctor_sc.doctor_info d on d.id = r.doctor_id where r.doctor_id=:doctorId"
    )
    List<Record> getRecordsByDoctorId(@Param("doctorId") Long doctorId);
    //todo дорабоатать
    @Query(
            nativeQuery = true,
            value = "select * from ms_record_sc.records r join ms_patient_sc.patients d on d.id = r.patient_id where r.patient_id=:patientId"

    )
    List<Record> getRecordsByPatientId(@Param("patientId") Long patientId);
}
