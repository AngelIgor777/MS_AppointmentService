package org.clinic.ms_appointmentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "doctor_schedules")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "time_start")
    LocalTime timeStart;
    @Column(name = "time_end")
    LocalTime timeEnd;
    @Column(name = "pause_start")
    LocalTime pauseStart;
    @Column(name = "pause_end")
    LocalTime pauseEnd;
}
