package org.clinic.ms_appointmentservice.entity;


import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "clinics")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clinic_id;
    private String name;
    private String description;

    @Override
    public String toString() {
        return "Clinic{" +
                "id=" + clinic_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
