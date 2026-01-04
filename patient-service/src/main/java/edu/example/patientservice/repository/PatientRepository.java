package edu.example.patientservice.repository;

import edu.example.patientservice.entity.PatientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends CrudRepository<PatientEntity, UUID> {
    boolean existsByEmail(String email);
}
