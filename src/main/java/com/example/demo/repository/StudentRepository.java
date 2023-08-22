/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.StudentModel;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface StudentRepository extends CrudRepository<StudentModel, String> {

    @Override
    StudentModel save(StudentModel data);

    @Override
    List<StudentModel> findAll();

    @Query("select u from student u where id = :id")
    StudentModel findOne(long id);

}
