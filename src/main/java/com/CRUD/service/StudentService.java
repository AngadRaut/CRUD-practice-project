package com.CRUD.service;

import com.CRUD.model.Student;
import org.springframework.stereotype.Service;

public interface StudentService {
    public Student saveStudent(Student saveStudent);
    public Student updateStudent(Student student);
}
