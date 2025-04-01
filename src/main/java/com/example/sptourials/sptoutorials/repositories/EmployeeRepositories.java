package com.example.sptourials.sptoutorials.repositories;

import com.example.sptourials.sptoutorials.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositories extends JpaRepository<EmployeeEntity,Long> {
}
