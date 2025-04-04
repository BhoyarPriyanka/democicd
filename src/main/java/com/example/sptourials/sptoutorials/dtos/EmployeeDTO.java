package com.example.sptourials.sptoutorials.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long employeeID;
    private String Name;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private boolean isActive;
}
