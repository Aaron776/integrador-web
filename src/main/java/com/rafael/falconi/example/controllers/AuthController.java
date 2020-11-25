package com.rafael.falconi.example.controllers;

import com.rafael.falconi.example.entities.Area;
import com.rafael.falconi.example.entities.Employee;
import com.rafael.falconi.example.entities.Position;
import com.rafael.falconi.example.reposotories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthController {
    private EmployeeRepository employeeRepository;

    @Autowired
    public AuthController(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public Optional<Area> login(Employee employee) {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(employee.getCi());
        if (!employeeOptional.isPresent()) return Optional.empty();
        Employee employeeDb = employeeOptional.get();
        if (employeeDb.getPassword().equals(employee.getPassword())
                && (employeeDb.getPosition() == Position.Gerente || employeeDb.getPosition() == Position.Subgerente)) {
            return Optional.of(employeeDb.getArea());
        } else {
            return Optional.empty();
        }

    }
    
    public Optional<Employee> loginEmployee(Employee employee) {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(employee.getCi());
        if (!employeeOptional.isPresent()) return Optional.empty();
        Employee employeeDb = employeeOptional.get();
        if (employeeDb.getPassword().equals(employee.getPassword())){
            return Optional.of(employeeDb);
        } else {
            return Optional.empty();
        }

    }
}
