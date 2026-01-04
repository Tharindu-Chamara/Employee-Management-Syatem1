package edu.example.patientservice.controller;

import edu.example.patientservice.dto.PatientDto;
import edu.example.patientservice.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientServiceController {

    private final PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        List<PatientDto> allPatients = patientService.getAllPatients();
        return ResponseEntity.ok(allPatients);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPatient(@Valid @RequestBody PatientDto patientDto) {
        String s = patientService.addPatient(patientDto);
        return ResponseEntity.ok().body(s);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePatient(@Valid @RequestBody PatientDto patientDto, @PathVariable UUID id) {
        patientService.updatePatient(patientDto, id);
        return ResponseEntity.ok().body("patient update success");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok().body("patient delete success");
    }

}
