package com.kodilla.ecommercee.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.logging.Logger;

@RestController
@ControllerAdvice
public class ExceptionHandlingController {


    @ExceptionHandler(NullPointerException.class)
    public final String handleNullPointerException(NullPointerException e) {
        return "Object that you refer to does not exist. Check if provided data are correct.";

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public final String handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return "Object data format does not match specified format. Check specification and try again";

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final String handleEntityNotFoundException(EntityNotFoundException e) {
        return "Object that you refer to does not exist. Check if provided data are correct.";

    }
}