package com.CRUD.service.impl;

import com.CRUD.dto.RegisterStudentDTO;
import com.CRUD.exception.DuplicateStudentException;
import com.CRUD.exception.StudentNotFoundException;
import com.CRUD.model.Student;
import com.CRUD.repository.StudentRepository;
import com.CRUD.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public Student saveStudent(Student saveStudent) {
        log.info("Save Student with name : {}", saveStudent.getFirstName());
        Student student = studentRepository.save(saveStudent);
        log.info("Student Save Successfully with id : {}", student.getId());
        return student;
    }

    @Override
    public List<Student> saveAll(List<Student> students) {
        log.info("Saving {} students", students.size());
        return studentRepository.saveAll(students);
    }


    @Transactional
    @Override
    public void updateStudent(Long id, Student update) {
        log.info("Updating student with id: {}", id);
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student old = student.get();
            old.setFirstName(update.getFirstName());
            old.setLastName(update.getLastName());
            old.setAddress(update.getAddress());
            old.setEmail(update.getEmail());
            old.setMobileNo(update.getMobileNo());
            old.setRollNo(update.getRollNo());
            old.setCollegeName(update.getCollegeName());
            old.setDob(update.getDob());
            old.setAge(update.getAge());
            log.info("Student Update successfully with id : {}", id);
            studentRepository.save(old);
        } else {
            log.warn("Student Not Found With id : {}", id);
            throw new StudentNotFoundException("Student Not Found.." + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        log.info("Student delete by id : {}", id);
        studentRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Student Not Found By id : {}", id);
                    return new StudentNotFoundException("Student Not Found " + id);
                });
        studentRepository.deleteById(id);
        log.info("Student Delete Successfully By id : {}", id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Student> findAll() {
        log.info("Get All Student");
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        log.info("Get Student By id:{}", id);
        return studentRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Student Not Found By Id : {}", id);
                    return new StudentNotFoundException("Student not found" + id);
                });
    }

    @Override
    public List<Student> findByName(String firstName) {
        log.info("Finding students with first name: {}", firstName);
        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public Student registerStudent(RegisterStudentDTO dto) {
        log.info("Registering student with email: {}", dto.getEmail());
        Student existing = studentRepository.getStudentByEmail(dto.getEmail());
        if (existing != null) {
            throw new DuplicateStudentException("Email already registered");
        }
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setAddress(dto.getAddress());
        student.setEmail(dto.getEmail());
        student.setMobileNo(dto.getMobileNo());
        student.setPassword(dto.getPassword());
        return studentRepository.save(student);
    }

    @Override
    public Student validateStudent(String email, String password) {
        log.info("Validating student with email: {}", email);
        Student student = studentRepository.getStudentByEmail(email);
        if (student == null) {
            throw new StudentNotFoundException("Invalid Email");
        }
        if (!student.getPassword().equals(password)) {
            throw new StudentNotFoundException("Invalid Password");
        }
        return student;
    }
}
