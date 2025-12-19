package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "students")
@Validated
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    public Student(
            Long id,
            @NotBlank(message = "Name cannot be empty") String name,
            @NotBlank(message = "Email cannot be empty")
            @Email(message = "Invalid email format") String email
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Student() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
