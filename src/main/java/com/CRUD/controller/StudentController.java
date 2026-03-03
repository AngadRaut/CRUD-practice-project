package com.CRUD.controller;

import com.CRUD.model.Student;
import com.CRUD.service.StudentService;
import com.CRUD.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    // used to add the new student in db
    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody Student std){
       Student student =  this.service.saveStudent(std);
       return ResponseEntity.status(HttpStatus.OK).body("student saved successfully with id: "+student.getId());
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id,@RequestBody Student std){
        std.setId(id);
        this.service.updateStudent(id,std);
        return ResponseEntity.status(HttpStatus.OK).body("Student data Updated Successfully");
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("Invalid student id");
        }
        this.service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Student Data Delete Successfully");
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        if (id <= 0){
            return ResponseEntity.badRequest().build();
        }
        Student student = service.findById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(service.findAll());
    }
}
