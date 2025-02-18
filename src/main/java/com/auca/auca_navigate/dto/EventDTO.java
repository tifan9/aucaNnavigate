package com.auca.auca_navigate.dto;

import java.time.LocalDateTime;

public class EventDTO {
    private String eventName;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String hostCampus;
    private String coordinator;
    private String description;
    private int studentId;

    public EventDTO() {
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getHostCampus() {
        return hostCampus;
    }

    public void setHostCampus(String hostCampus) {
        this.hostCampus = hostCampus;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
