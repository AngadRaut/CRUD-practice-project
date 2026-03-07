package com.CRUD.service;

import com.CRUD.dto.RegisterStudentDTO;
import com.CRUD.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student saveStudent);

    List<Student> saveAll(List<Student> students);

    void updateStudent(Long id, Student student);

    void deleteById(Long id);

    List<Student> findAll();

    Student findById(Long id);

    List<Student> findByName(String firstName);

    public Student registerStudent(RegisterStudentDTO registerStudentDTO);

    public Student validateStudent(String email, String password);
}
