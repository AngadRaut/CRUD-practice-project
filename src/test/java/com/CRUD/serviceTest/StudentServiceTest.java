/*
package com.CRUD.serviceTest;


import com.CRUD.model.Student;
import com.CRUD.repository.StudentRepository;
import com.CRUD.service.StudentService;

//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void findById(){

        Student student = new Student();

        student.setId(1L);
        student.setFirstName("Avinash");
        student.setLastName("Surwase");

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Student result = studentService.findById(1L);

        // Assert
        assertEquals("Avinash", result.getFirstName());

        // Verify repository call
        verify(studentRepository).findById(1L);
    }

}*/
