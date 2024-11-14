package org.clinic.ms_appointmentservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.clinic.ms_appointmentservice.repository.ClinicRepository;

@Service
@RequiredArgsConstructor
public class ClinicService {
    private final ClinicRepository repository;

}
