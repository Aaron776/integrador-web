package com.rafael.falconi.example.api_controllers;

import com.rafael.falconi.example.api_controllers.exceptions.LoginException;
import com.rafael.falconi.example.controllers.AuthController;
import com.rafael.falconi.example.entities.Area;
import com.rafael.falconi.example.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = AuthResource.AUTH)
public class AuthResource {
    public static final String AUTH = "/auth";
    public static final String ADMIN = "/admin";
    private AuthController authController;


    @Autowired
    public AuthResource(AuthController authController) {

        this.authController = authController;
    }

    @PostMapping(value = AuthResource.ADMIN)
    public ResponseEntity loginAdmin(@Valid @RequestBody Employee employee) throws LoginException {
        try {
            Optional<Area> areaOptional = this.authController.login(employee);
            if (!areaOptional.isPresent()) return new ResponseEntity("\"datos incorrectos\"", HttpStatus.BAD_REQUEST);
            return new ResponseEntity(areaOptional.get(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw  new LoginException("datos incorrectos");
        }

    }


}
