package com.rafael.falconi.example.api_controllers;

import com.rafael.falconi.example.entities.Area;
import com.rafael.falconi.example.entities.Employee;
import com.rafael.falconi.example.reposotories.AreaRepository;
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
public class EmployeeResourceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Autowired
    private RestService restService;
    private Employee employee;
    private Area area;

    @Before
    public void before() {
        this.employee = new Employee();
        this.employee.setCi("1725159683");
        this.area = new Area(1, "Contabilidad");
    }


    @Test
    public void listEmployeeBy() {
        String json = restService.restBuilder(new RestBuilder<String>().clazz(String.class))
                .path(EmployeeResource.EMPLOYEE).path(EmployeeResource.AREA).path(EmployeeResource.ID).expand(1).get().build();
        System.out.println(json);
    }
}