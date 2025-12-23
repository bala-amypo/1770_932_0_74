package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentEntity saveStudent(StudentEntity student) {
        return repo.save(student);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public StudentEntity updateStudent(Long id, StudentEntity student) {
        StudentEntity existing = repo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        return repo.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
