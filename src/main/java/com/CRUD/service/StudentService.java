package com.CRUD.service;

import com.CRUD.model.Student;

import java.util.List;

public interface StudentService {
     Student saveStudent(Student saveStudent);
     Student updateStudent(Long id, Student student);
     void deleteById(Long id);
    List<Student> findAll();
     Student findById(Long id);
}
