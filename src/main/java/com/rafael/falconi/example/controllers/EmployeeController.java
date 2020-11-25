package com.rafael.falconi.example.controllers;

import com.rafael.falconi.example.entities.Area;
import com.rafael.falconi.example.entities.Employee;
import com.rafael.falconi.example.reposotories.AreaRepository;
import com.rafael.falconi.example.reposotories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReferenceArray;

@Controller
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    private AreaRepository areaRepository;


    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository,AreaRepository areaRepository) {
        this.employeeRepository = employeeRepository;
        this.areaRepository= areaRepository;

    }


    public List<Employee> findEmployeesByArea(int id){
        Optional<Area> areaDb= this.areaRepository.findById(id);
        Area area= areaDb.get();
        return  this.employeeRepository.findEmployeesByArea(area);

    }
}
