package edu.example.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    @NotBlank
    private String name;

    @NotBlank
    @Email(message = "Email id required")
    private String email;

    @NotBlank(message ="Address is required")
    private String address;

    @NotBlank(message = " date of birth is required")
    private String dateOfBirth;

    @NotBlank(message = " registration date is required")
    private  String registrationDate;
}
