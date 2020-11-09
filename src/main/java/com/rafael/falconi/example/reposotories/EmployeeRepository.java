package com.rafael.falconi.example.reposotories;

import com.rafael.falconi.example.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
