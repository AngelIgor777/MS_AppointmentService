package org.clinic.ms_appointmentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.clinic.ms_appointmentservice.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor_info")
public class Doctor {
    @Id
    @Column(name = "user_id")
    private Long id;
    private Long clinic_id;
    @Column(name = "birthdate")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    @Column(name = "cabinet")
    private String roomNumber;
    private int floor;
    private String speciality;
    @Column(name="years_of_experience")
    private int experience;
    private String description;
    @Column(name = "schedule_id")
    private Long scheduleId;
}
