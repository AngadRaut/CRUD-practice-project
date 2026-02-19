package com.CRUD.service.impl;

import com.CRUD.exception.StudentNotFoundException;
import com.CRUD.model.Student;
import com.CRUD.repository.StudentRepository;
import com.CRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student saveStudent) {
        return this.studentRepository.save(saveStudent);
    }

    @Override
    public void updateStudent(Student update) {

        Optional<Student> student = studentRepository.findById(update.getId());
        if (student.isPresent()){
            Student old = student.get();

            /// update require filed
            old.setFirstName(update.getFirstName());
            old.setLastName(update.getLastName());
            old.setAddress(update.getAddress());
            old.setEmail(update.getEmail());
            old.setMobileNo(update.getMobileNo());
            old.setRollNo(update.getRollNo());
            old.setCollegeName(update.getCollegeName());
            old.setDob(update.getDob());
            old.setAge(update.getAge());

            /// saving Updated Objects
            this.studentRepository.save(old);

        }else {
            throw new StudentNotFoundException("Student Not Found.." + update.getId());
        }
    }

}
