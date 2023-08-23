/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.xml.bind.DataBindingException;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.HibernateQueryException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

/**
 *
 * @author DELL
 */
@ControllerAdvice
public class CustomExceptionHandlerController extends RuntimeException {

    @ExceptionHandler(HibernateError.class)
    public ResponseEntity<Object> HibernateError(HibernateError ex) {
        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.CONFLICT);
        body.put("message", ex.getLocalizedMessage());
        return new ResponseEntity<Object>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(HibernateException.class)
    public ResponseEntity<Object> HibernateException(HibernateException ex) {
        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.CONFLICT);
        body.put("message", ex.getLocalizedMessage());
        return new ResponseEntity<Object>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(HibernateQueryException.class)
    public ResponseEntity<Object> HibernateQueryException(HibernateQueryException ex) {
        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.CONFLICT);
        body.put("message", ex.getLocalizedMessage());
        return new ResponseEntity<Object>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> ConstraintViolationException(ConstraintViolationException ex) {

        List<String> errorList = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errorList.add("Value rejected in '" + violation.getPropertyPath().toString().toUpperCase() + "' field. Description : " + violation.getMessage().toString().toUpperCase());
        }
        
        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.CONFLICT);
        body.put("message", "Data Validation Error : " + errorList);
        return new ResponseEntity<Object>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.CONFLICT);
        body.put("message", "Data Validation Error : " + errors);
        return new ResponseEntity<Object>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(DataBindingException.class)
    public ResponseEntity<Object> DataBindingException(DataBindingException ex
    ) {
        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.CONFLICT);
        body.put("message", ex.getLocalizedMessage());
        return new ResponseEntity<Object>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<Object> InternalServerError(InternalServerError ex
    ) {
        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.CONFLICT);
        body.put("message", ex.getLocalizedMessage());
        return new ResponseEntity<Object>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<Object> BadRequest(BadRequest ex
    ) {
        final Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.CONFLICT);
        body.put("message", ex.getLocalizedMessage());
        return new ResponseEntity<Object>(body, HttpStatus.CONFLICT);
    }
}