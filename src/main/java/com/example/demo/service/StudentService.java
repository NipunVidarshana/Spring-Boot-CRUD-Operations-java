/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public boolean save(String username, String address) {
//        System.out.println("Username is " + username);
//        System.out.println("Address is " + address);

        try {
            StudentModel student = new StudentModel();
            student.setUsername(username);
            student.setAddress(address);
            repository.save(student);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public List<StudentModel> findAll() {
        return repository.findAll();
    }
    
     public StudentModel findOne(Long id) {
        return repository.findOne(id);
    }
}
