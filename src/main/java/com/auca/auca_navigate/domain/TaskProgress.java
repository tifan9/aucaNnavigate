package com.auca.auca_navigate.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class TaskProgress {
    // TODO: Implement progress tracking
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @JsonBackReference
    private Student student;
    private boolean schoolTour;
    private boolean accessPolicies;
    private boolean accountsSetup;
    private boolean registration;

    public TaskProgress() {}

    public TaskProgress(int id, Student student, boolean schoolTour, boolean accessPolicies, boolean accountsSetup, boolean registration) {
        this.id = id;
        this.student = student;
        this.schoolTour = schoolTour;
        this.accessPolicies = accessPolicies;
        this.accountsSetup = accountsSetup;
        this.registration = registration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isSchoolTour() {
        return schoolTour;
    }

    public void setSchoolTour(boolean schoolTour) {
        this.schoolTour = schoolTour;
    }

    public boolean isAccessPolicies() {
        return accessPolicies;
    }

    public void setAccessPolicies(boolean accessPolicies) {
        this.accessPolicies = accessPolicies;
    }

    public boolean isAccountsSetup() {
        return accountsSetup;
    }

    public void setAccountsSetup(boolean accountsSetup) {
        this.accountsSetup = accountsSetup;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }
}
