package com.CRUD.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Address")
    private String address;
    @Column(name = "Email")
    private String email;
    @Column(name = "Mobile_No")
    private String mobileNo;
    @Column(name = "Roll_No")
    private int rollNo;
    @Column(name = "College_Name")
    private String collegeName;
    @Column(name = "Date_Of_Birth")
    private String dob;
    @Column(name = "Age")
    private int age;

}
