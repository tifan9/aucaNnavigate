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
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private TaskProgress taskProgress;
    public Student() {
    }

    public Student(int id, String fullName, String email, String phone, String password, TaskProgress taskProgress) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.taskProgress = taskProgress;
    }

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

    public TaskProgress getTaskProgress() {
        return taskProgress;
    }

    public void setTaskProgress(TaskProgress taskProgress) {
        this.taskProgress = taskProgress;
    }
}

