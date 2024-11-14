package org.clinic.ms_appointmentservice.entity;


import lombok.*;
import org.clinic.ms_appointmentservice.enums.RecordState;
import org.clinic.ms_appointmentservice.enums.RecordType;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "doctor_id")
    private Long doctorId;
    private LocalDate date;
    private LocalTime time;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RecordState status;
    @Enumerated(EnumType.STRING)
    private RecordType type;
    private String notes;

    public void setDate(String date) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    }

    public void setTime(String time) {
        this.time = LocalTime.parse(time, DateTimeFormatter.ISO_TIME);
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", status=" + status +
                '}';
    }

}
