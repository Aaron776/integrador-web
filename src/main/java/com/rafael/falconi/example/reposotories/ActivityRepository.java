package com.rafael.falconi.example.reposotories;

import com.rafael.falconi.example.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.rafael.falconi.example.entities.Employee;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {

	public List<Activity> findActivityByEmployees(Employee employee);
	
	
	
}
