package com.auca.auca_navigate.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "student_generator",
            sequenceName = "student_sequence_name",
            allocationSize = 1
    )
    private int studentId;
    private String fullName;
    private String email;
    private String phone;
    private String password;
    @OneToMany(mappedBy = "student")
    private List<Orientation> orientations;

    public Student() {
    }

    public Student(String email, String fullName, List<Orientation> orientations, String password, String phone, int studentId) {
        this.email = email;
        this.fullName = fullName;
        this.orientations = orientations;
        this.password = password;
        this.phone = phone;
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Orientation> getOrientations() {
        return orientations;
    }

    public void setOrientations(List<Orientation> orientations) {
        this.orientations = orientations;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}