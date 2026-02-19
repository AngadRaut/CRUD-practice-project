package com.CRUD.controller;

import com.CRUD.model.Student;
import com.CRUD.service.StudentService;
import com.CRUD.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /// this controller is used to Update Student Data
    @PutMapping("/updateStudent")
    public ResponseEntity<?> updateStudent(@PathVariable Long id,@RequestBody Student std){
        std.setId(id);
        this.service.updateStudent(std);
        return ResponseEntity.status(HttpStatus.OK).body("Student data Updated Successfully");
    }
}
