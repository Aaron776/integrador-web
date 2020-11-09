package com.rafael.falconi.example.reposotories;

import com.rafael.falconi.example.entities.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area,Integer> {
}
