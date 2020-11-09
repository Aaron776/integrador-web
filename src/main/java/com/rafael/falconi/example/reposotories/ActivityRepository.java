package com.rafael.falconi.example.reposotories;

import com.rafael.falconi.example.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {
}
