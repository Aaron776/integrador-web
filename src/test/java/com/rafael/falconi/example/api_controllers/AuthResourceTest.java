package com.rafael.falconi.example.api_controllers;

import com.rafael.falconi.example.entities.Employee;
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
public class AuthResourceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private RestService restService;
    private Employee employee;

    @Before
    public void Before() {
        this.employee = new Employee();
        this.employee.setCi("1725159683");
        this.employee.setPassword("3489543578");

    }

    @Test
    public void loginAdmin() {
        restService.restBuilder().path(AuthResource.AUTH).path(AuthResource.ADMIN).body(employee).post().build();

    }

}
