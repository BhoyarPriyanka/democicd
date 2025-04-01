package com.example.sptourials.sptoutorials.controllers;

import com.example.sptourials.sptoutorials.dtos.EmployeeDTO;
import com.example.sptourials.sptoutorials.entities.EmployeeEntity;
import com.example.sptourials.sptoutorials.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EmployeeController {
    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path="/employees/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeByID(id);
    }
    @GetMapping(path="/allemployees")
    public List<EmployeeDTO> getAllEmployee()
    {
      return employeeService.getAllEmployee();
    }

    @DeleteMapping(path="/employees/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id)
    {
        return employeeService.deleteEmployeeById(id);
    }
    @GetMapping(path="/employees")
    public String getData(@PathParam("sortBy") String sortBy,@PathParam("limit") int limit)
    {
        return "SortBy="+sortBy+" limit="+limit;
    }
    @PostMapping(path="/employees")
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeEntity)
    {
        return employeeService.createEmployee(employeeEntity);

    }
}
