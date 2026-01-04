package edu.example.patientservice.service;

import edu.example.patientservice.dto.PatientDto;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    List<PatientDto> getAllPatients();
    String addPatient(PatientDto patientDto);
    void updatePatient(PatientDto patientDto, UUID id);
    void deletePatient(UUID id);
}
