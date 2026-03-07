package com.CRUD.controller;

import com.CRUD.dto.LoginStudentDTO;
import com.CRUD.dto.RegisterStudentDTO;
import com.CRUD.exception.DuplicateStudentException;
import com.CRUD.model.Student;
import com.CRUD.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    public static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@Valid @RequestBody RegisterStudentDTO dto){
        log.info("Student registration started for email: {}", dto.getEmail());
        service.registerStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student Register Successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginStudent(@Valid @RequestBody LoginStudentDTO dto){
        log.info("Student Enter Into Validation Process for email: {}", dto.getEmail());
        service.validateStudent(dto.getEmail(), dto.getPassword());
        return ResponseEntity.ok("Student Login Successfully..!");
    }

    // used to add the new student in db
    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@Valid @RequestBody Student std) {
        log.info("addStudent Api Call");
        log.debug("Saving student into database");
        Student student = this.service.saveStudent(std);
        log.info("Student saved successfully with id: {}", student.getId());
        return ResponseEntity.status(HttpStatus.OK).body("student saved successfully with id: " + student.getId());
    }

    @PostMapping("/addAllStudent")
    public ResponseEntity<String> addStudents(@RequestBody List<Student> students) {
        log.info("addAllStudent Api Call");
        log.debug("Saving All Student into database");
        List<Student> savedStudents = service.saveAll(students);
        log.info("Total students saved: {}", savedStudents.size());
        return ResponseEntity.ok("All students saved successfully");
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@Valid @PathVariable Long id,
                                           @RequestBody Student std) {
        std.setId(id);
        log.info("updateStudent Api Call");
        log.debug("Update Student Data into Database");
        this.service.updateStudent(id, std);
        log.info("Student Successfully Update");
        return ResponseEntity.status(HttpStatus.OK).body("Student data Updated Successfully");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        if (id == null || id <= 0) {
            log.warn("Invalid student id received: {}", id);
            return ResponseEntity.badRequest().body("Invalid student id");
        }
        log.debug("Student Delete From Database");
        this.service.deleteById(id);
        log.info("Student Delete Successfully by id: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body("Student Data Delete Successfully");
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        log.info("Searching student with id: {}", id);
        if (id <= 0) {
            log.warn("Invalid students id {}", id);
            return ResponseEntity.badRequest().build();
        }
        log.debug("Get Student form Database");
        Student student = service.findById(id);
        log.info("Student find Successfully with id: {}", id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getAllStudents() {
        log.info("getAllStudent Api called");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findByName/{firstName}")
    public ResponseEntity<?> findByName(@PathVariable String firstName) {
        log.info("Searching student with name: {}", firstName);
        List<Student> byName = service.findByName(firstName);
        if (byName.isEmpty()) {
            log.warn("Student not found with name {}", firstName);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not found");
        }
        log.info("Student find with name: {}", firstName);
        return ResponseEntity.ok(byName);
    }
}
