package com.CRUD.service;

import com.CRUD.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student saveStudent);

    List<Student> saveAll(List<Student> students);

    Student updateStudent(Long id, Student student);

    void deleteById(Long id);

    List<Student> findAll();

    Student findById(Long id);
}
