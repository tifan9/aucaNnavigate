package com.auca.auca_navigate.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Orientation {
    // TODO: Implement progress tracking
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orientationId;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    @JsonBackReference
    private Student student;
    private boolean schoolTour;
    private boolean accessPolicies;
    private boolean accountsSetup;
    private boolean registration;

    public Orientation() {
    }

    public Orientation(boolean accessPolicies, boolean accountsSetup, int orientationId, boolean registration, boolean schoolTour, Student student) {
        this.accessPolicies = accessPolicies;
        this.accountsSetup = accountsSetup;
        this.orientationId = orientationId;
        this.registration = registration;
        this.schoolTour = schoolTour;
        this.student = student;
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

    public int getOrientationId() {
        return orientationId;
    }

    public void setOrientationId(int orientationId) {
        this.orientationId = orientationId;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public boolean isSchoolTour() {
        return schoolTour;
    }

    public void setSchoolTour(boolean schoolTour) {
        this.schoolTour = schoolTour;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
