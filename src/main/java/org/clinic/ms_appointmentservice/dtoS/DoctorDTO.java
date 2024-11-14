package org.clinic.ms_appointmentservice.dtoS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.clinic.ms_appointmentservice.enums.Gender;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private Long clinic_id;
    private LocalDate birthDate;
    private Gender gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String roomNumber;
    private int floor;
    private String speciality;
    private int experience;
    private String description;
}
