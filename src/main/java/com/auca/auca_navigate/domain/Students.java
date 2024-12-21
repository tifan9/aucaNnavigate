package com.auca.auca_navigate.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(
            name = "student_generator",
            sequenceName = "student_sequence_name",
            allocationSize = 1
    )
    private int stId;
    private String fullName;
    private String email;
    private String  phone;
    private String password;

    public Students() {
    }

    public Students(String password, String phone, String email, String fullName, int stId) {
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.stId = stId;
    }
    // Getters and setters

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
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

