package org.clinic.ms_appointmentservice.response;

import lombok.Data;
import org.clinic.ms_appointmentservice.enums.RecordState;
import org.clinic.ms_appointmentservice.enums.RecordType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class RecordResponse {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private LocalDate date;
    private LocalTime time;
    private RecordState status;
    private RecordType type;
    private String notes;
}
