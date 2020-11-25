package com.rafael.falconi.example.api_controllers;

import com.rafael.falconi.example.api_controllers.exceptions.LoginException;
import com.rafael.falconi.example.controllers.ActivityController;
import com.rafael.falconi.example.controllers.AuthController;
import com.rafael.falconi.example.entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = ActivityResource.ACTIVITY)
public class ActivityResource {
    public static final String ACTIVITY = "/activities";
    private ActivityController activityController;

    @Autowired
    public ActivityResource(ActivityController activityController) {
        this.activityController = activityController;
    }

    @PostMapping
    public ResponseEntity createActivity(@Valid @RequestBody Activity activity) throws LoginException {
        try {
            this.activityController.createActivity(activity);
            return new ResponseEntity("\"la actividad fue creada\"", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new LoginException("los datos enviados no son los correctos");
        }

    }
}
