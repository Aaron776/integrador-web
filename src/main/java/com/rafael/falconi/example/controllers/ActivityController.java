package com.rafael.falconi.example.controllers;

import com.rafael.falconi.example.entities.Activity;
import com.rafael.falconi.example.reposotories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Controller

public class ActivityController {
    private ActivityRepository activityRepository;

    @Autowired
    public ActivityController(ActivityRepository activityRepository) {

        this.activityRepository = activityRepository;
    }

    public void createActivity(Activity activity) {
        LocalDateTime now = LocalDateTime.now();
        Date date = java.util.Date.from(now.atZone(ZoneId.systemDefault())
                .toInstant());
        activity.setDate(date);
        this.activityRepository.save(activity);

    }

    public boolean editActivity(Activity activity, int id) {
        Optional<Activity> activityDb = this.activityRepository.findById(id);
        if (!activityDb.isPresent()) return false;
        Activity activity1 = activityDb.get();
        activity1.setMessage(activity.getMessage());
        this.activityRepository.save(activity1);
        return true;
    }
}
