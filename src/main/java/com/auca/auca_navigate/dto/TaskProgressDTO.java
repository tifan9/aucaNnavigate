package com.auca.auca_navigate.dto;

import com.auca.auca_navigate.domain.TaskProgress;

public class TaskProgressDTO {
    private int id;
    private String studentName;
    private boolean schoolTour;
    private boolean accessPolicies;
    private boolean accountsSetup;
    private boolean registration;

    // Constructor
    public TaskProgressDTO(TaskProgress taskProgress) {
        this.id = taskProgress.getId();
        this.studentName = taskProgress.getStudent().getFullName();
        this.schoolTour = taskProgress.isSchoolTour();
        this.accessPolicies = taskProgress.isAccessPolicies();
        this.accountsSetup = taskProgress.isAccountsSetup();
        this.registration = taskProgress.isRegistration();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
