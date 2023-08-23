/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.StudentModel;
import com.example.demo.response.MessageResponse;
import com.example.demo.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentController {

    @Autowired
    StudentService service;

    @RequestMapping(value = "/restapi/save/student", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST)
    public ResponseEntity<?> save(@Valid @RequestBody StudentModel data, BindingResult result, HttpSession session) {
        //this method is use for save new user to the db
        
         if (result.hasErrors()) {
            List<String> errorList = new ArrayList<>();
            result.getAllErrors().forEach((error) -> {
                String fieldErrorsFeild = ((FieldError) error).getField();
                String fieldErrorsDescription = ((FieldError) error).getDefaultMessage();
                String fieldErrorsRejectedValue = ((FieldError) error).getRejectedValue().toString();
                errorList.add("Value rejected in '" + fieldErrorsFeild + "' field.Description : " + fieldErrorsDescription);
            });
            return ResponseEntity.badRequest().body(new MessageResponse("Error : " + errorList));
        }
        
        try {
            service.save(data);
            return ResponseEntity.ok(new MessageResponse("Saved successfully!"));
            //message response class located in "com.example.demo.response"
        } catch (Exception e) {
            System.out.println("================== error occured ================");
            System.out.println(e.getMessage());
            System.out.println("================== error occured ================");
            return ResponseEntity.badRequest().body(new MessageResponse("Error : Data not saved. Exception is : " + e.getMessage()));
            //message response class located in "com.example.demo.response"
        }
    }

    @RequestMapping(value = "/restapi/get/one/student/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<StudentModel> findOne(@PathVariable Long id) {
        //this method is use for get one student from db. 
        //ex: place student id as a parameter.
        //ex: /restapi/get/one/student/1
        StudentModel outputData = service.findOne(id);
        if (outputData == null) {
            return new ResponseEntity<StudentModel>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<StudentModel>(outputData, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/restapi/get/all/students", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<List<StudentModel>> findAll() {
        //this method is use for get all students list from db
        List<StudentModel> outputData = service.findAll();
        if (outputData.isEmpty()) {
            return new ResponseEntity<List<StudentModel>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<StudentModel>>(outputData, HttpStatus.OK);

    }

    

}
