package com.auca.auca_navigate.domain;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "student_generator",
            sequenceName = "student_sequence_name",
            allocationSize = 1
    )
    private int id;
    private String fullName;
    private String email;
    private String  phone;
    private String password;

    public Student() {
    }

    public Student(String password, String phone, String email, String fullName, int id) {
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.id = id;
    }
    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

