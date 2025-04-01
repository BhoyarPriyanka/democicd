package com.example.sptourials.sptoutorials.services;

import com.example.sptourials.sptoutorials.dtos.EmployeeDTO;
import com.example.sptourials.sptoutorials.entities.EmployeeEntity;
import com.example.sptourials.sptoutorials.repositories.EmployeeRepositories;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    final EmployeeRepositories employeeRepositories;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepositories employeeRepositories, ModelMapper modelMapper) {
        this.employeeRepositories = employeeRepositories;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeByID(Long id)
    {
        EmployeeEntity employeeEntity=employeeRepositories.getById(id);
        return modelMapper.map(employeeEntity,EmployeeDTO.class);
    }
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO)
    {   EmployeeEntity employeeEntity= modelMapper.map(employeeDTO,EmployeeEntity.class);
        return modelMapper.map(employeeRepositories.save(employeeEntity),EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepositories.findAll()
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public boolean deleteEmployeeById(Long id) {

        if(employeeRepositories.existsById(id))
        {
            employeeRepositories.deleteById(id);
            return true;
        }
        return false;
    }
}
