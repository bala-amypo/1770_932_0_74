package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private float cgpa;

    public StudentEntity(
            @NotBlank String name,
            @NotBlank @Email String email,
            @DecimalMin("0.0") @DecimalMax("10.0") float cgpa
    ) {
        this.name = name;
        this.email = email;
        this.cgpa = cgpa;
    }

    public StudentEntity() {}

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public float getCgpa() {
        return cgpa;
    }
}
