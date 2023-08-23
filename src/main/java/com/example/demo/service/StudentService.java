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

    public boolean save(StudentModel data) {

        try {
            repository.save(data);
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
