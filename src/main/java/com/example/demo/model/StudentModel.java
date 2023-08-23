/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import javax.persistence.*;

/**
 *
 * @author DELL
 */

@Entity(name = "student")//table name create as "student"
public class StudentModel {

    @Id//use @id for tell this feild is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this is use to tell hibernate to create a auto increment number
    private Long id; //database feild create as id 
    
    String username;//database feild create as username
    
    String address;//database feild create as address

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
