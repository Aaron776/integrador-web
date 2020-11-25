package com.rafael.falconi.example.api_controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeException extends Exception {
    private static final long serialVersionUID = -7717691994704695707L;

    public EmployeeException(String message){
        super(message);
    }
}
