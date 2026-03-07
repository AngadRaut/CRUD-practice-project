package com.CRUD.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "student_data")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Address")
    private String address;

    @Column(name = "Email", unique = true)
    @Pattern(regexp = "^[A-Za-z0-9+.-]+@[A-Za-z0-9+.-]+\\.(com|co\\.in|org)$")
    private String email;

    @Column(name = "Mobile_No")
    @Pattern(regexp = "^(\\+91)?[6-9]\\d{9}$")
    private String mobileNo;

    @Column(name = "Password")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    private String password;

    @Column(name = "Roll_No", unique = true)
    private Integer rollNo;

    @Column(name = "College_Name")
    private String collegeName;

    @Column(name = "Date_Of_Birth")
    private String dob;

    @Column(name = "Age")
    private Integer age;
}
