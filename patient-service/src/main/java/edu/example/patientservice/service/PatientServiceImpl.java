package edu.example.patientservice.service;

import edu.example.patientservice.dto.PatientDto;
import edu.example.patientservice.entity.PatientEntity;
import edu.example.patientservice.exception.EmailAlreadyExistException;
import edu.example.patientservice.exception.PatientNotFoundException;
import edu.example.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{

    private final PatientRepository repository;
    private final ObjectMapper objectMapper;

    @Override
    public List<PatientDto> getAllPatients() {
        List<PatientDto> patientList = new ArrayList<>();
        repository.findAll().forEach(patient ->
                patientList.add(objectMapper.convertValue(patient,PatientDto.class)));
        return patientList;
    }

    @Override
    public String addPatient(PatientDto patientDto) {
        if (repository.existsByEmail(patientDto.getEmail())){
            throw new EmailAlreadyExistException("Email already exists");
        }
        repository.save(objectMapper.convertValue(patientDto, PatientEntity.class));
        return "Patient added successfully";
    }

    @Override
    public void updatePatient(PatientDto patientDto, UUID id) {
        PatientEntity patient1 = repository.findById(id).orElseThrow(
                () -> new PatientNotFoundException("Patient not found this id"));
        patient1.setAddress(patientDto.getAddress());
        patient1.setEmail(patientDto.getEmail());
        patient1.setName(patientDto.getName());
        patient1.setDateOfBirth(patientDto.getDateOfBirth());
        patient1.setId(id);
        repository.save(patient1);
    }

    @Override
    public void deletePatient(UUID id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
        throw new PatientNotFoundException("Patient not found this id.");
    }
}
