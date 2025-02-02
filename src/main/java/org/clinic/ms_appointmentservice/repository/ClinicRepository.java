package org.clinic.ms_appointmentservice.repository;

import org.clinic.ms_appointmentservice.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
