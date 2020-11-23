package com.rafael.falconi.example.api_controllers;

import com.rafael.falconi.example.entities.Activity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ActivityResourceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;
    private Activity activity;

    @Before
    public void Before() {
        this.activity = new Activity();
        this.activity.setMessage("La actividad ha sido cambiada");
    }


    @Test
    public void editActivity() {
        this.restService.restBuilder().path(ActivityResource.ACTIVITY).path(ActivityResource.ID).expand(2)
                .body(this.activity).put().build();
    }
}