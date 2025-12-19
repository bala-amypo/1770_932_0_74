package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "10.0")
    private float cgpa;

    public StudentEntity(
            @NotBlank String name,
            @Email @NotBlank String email,
            @DecimalMin("0.0") @DecimalMax("10.0") float cgpa
    ) {
        this.name = name;
        this.email = email;
        this.cgpa = cgpa;
    }
    public StudentEntity(){

    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setCgpa(float cgpa){
        this.cgpa = cgpa;
    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public float getCgpa(){
        return this.cgpa;
    }
    

}