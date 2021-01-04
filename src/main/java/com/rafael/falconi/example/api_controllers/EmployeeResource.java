package com.rafael.falconi.example.api_controllers;

import com.rafael.falconi.example.controllers.EmployeeController;
import com.rafael.falconi.example.entities.Employee;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(EmployeeResource.EMPLOYEE)
public class EmployeeResource {
    public static final String EMPLOYEE = "/employees";
    public static final String AREA = "/area";
    public static final String ID = "/{id}";

    private EmployeeController employeeController;

    @Autowired
    public EmployeeResource(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    @GetMapping(value = AREA + ID)
    public List<Employee> listEmployeeByArea(@PathVariable int id) {
        return this.employeeController.findEmployeesByArea(id);

    }


}
