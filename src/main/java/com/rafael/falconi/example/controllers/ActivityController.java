package com.rafael.falconi.example.controllers;

import com.rafael.falconi.example.entities.Activity;
import com.rafael.falconi.example.reposotories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ActivityController {
    private ActivityRepository activityRepository;

    @Autowired
    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public void createActivity(Activity activity) {
        this.activityRepository.save(activity);

    }
}
