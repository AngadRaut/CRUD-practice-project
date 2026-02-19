package com.CRUD.service.impl;

import com.CRUD.model.Student;
import com.CRUD.repository.StudentRepository;
import com.CRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student saveStudent) {
        return this.studentRepository.save(saveStudent);
    }

    @Override
    public Student updateStudent(Student update) {
        return this.studentRepository.save(update);
    }

}
