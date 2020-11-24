package com.rafael.falconi.example.api_controllers;

import com.rafael.falconi.example.api_controllers.exceptions.ActivityException;
import com.rafael.falconi.example.controllers.ActivityController;
import com.rafael.falconi.example.entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ActivityResource.ACTIVITY)
public class ActivityResource {
    public static  final String ACTIVITY="/activities";
    public static final String ID= "/{id}";

    private ActivityController activityController;

    @Autowired

    public ActivityResource(ActivityController activityController) {
        this.activityController = activityController;
    }

    @PutMapping(value = ID)
    public ResponseEntity editActivity(@PathVariable int id, @Valid @RequestBody Activity activity) throws ActivityException {
        try{
            if (!this.activityController.editActivity(activity,id))return new ResponseEntity("\"la actividad no fue encontrada\"",HttpStatus.NOT_FOUND);
            return new ResponseEntity("\"actividad modificada\"", HttpStatus.ACCEPTED);
        }catch(Exception e){
            throw new ActivityException("la actividad ha sido modificada");

        }

    }

}
