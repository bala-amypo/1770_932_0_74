package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentEntity> createStudent(
            @Valid @RequestBody StudentEntity student) {
        return new ResponseEntity<>(
                service.saveStudent(student),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentEntity getStudent(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentEntity updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentEntity student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
