package com.auca.auca_navigate.dto;

import com.auca.auca_navigate.domain.Orientation;

public class OrientationDTO {
    private int orientationId;
    private int studentId;
    private boolean schoolTour;
    private boolean accessPolicies;
    private boolean accountsSetup;
    private boolean registration;

    // Constructor

    public OrientationDTO() {
    }

    public OrientationDTO(boolean accessPolicies, boolean accountsSetup, int orientationId, boolean registration, boolean schoolTour,int studentId) {
        this.accessPolicies = accessPolicies;
        this.accountsSetup = accountsSetup;
        this.orientationId = orientationId;
        this.registration = registration;
        this.schoolTour = schoolTour;
        this.studentId = studentId;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
