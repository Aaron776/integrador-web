package com.rafael.falconi.example.reposotories;


import com.rafael.falconi.example.entities.Area;
import com.rafael.falconi.example.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    public List<Employee> findEmployeesByArea(Area area);

}
