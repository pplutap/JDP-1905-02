package com.kodilla.ecommercee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@RestController
@ControllerAdvice
public class ExceptionHandlingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlingController.class);

    @ExceptionHandler(NullPointerException.class)
    public final String handleNullPointerException(NullPointerException e) {
        LOGGER.error(e.getMessage(), e);
        return "Object that you refer to does not exist. Check if provided data are correct.";

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public final String handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        LOGGER.error(e.getMessage(), e);
        return "Object data format does not match specified format. Check specification and try again";

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public final String handleEntityNotFoundException(EntityNotFoundException e) {
        LOGGER.error(e.getMessage(), e);
        return "Object that you refer to does not exist. Check if provided data are correct.";

    }

    @ExceptionHandler(NoSuchElementException.class)
    public final String handleNoSuchElementException(NoSuchElementException e) {
        LOGGER.error(e.getMessage(), e);
        return "Object that you refer to does not exist. Check if provided data are correct.";

    }
}