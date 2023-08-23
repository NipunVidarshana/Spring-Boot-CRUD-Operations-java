/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
public class StudentController {
    
    @Autowired
    StudentService service;

    @RequestMapping(value = "/restapi/save/student/{username}/{address}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public String save(@PathVariable String username,@PathVariable String address) {
        //this method is use for save new user to the db
        service.save(username, address);
        return "User Saved";
    }
    
    @RequestMapping(value = "/restapi/get/all/students", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public List<StudentModel> findAll() {
        //this method is use for get all students list from db
        return service.findAll();
    }
    
    @RequestMapping(value = "/restapi/get/one/student/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public StudentModel findOne(@PathVariable Long id) {
        //this method is use for get one student from db. 
        //ex: place student id as a parameter.
        //ex: /restapi/get/one/student/1
        return service.findOne(id);
    }

}
