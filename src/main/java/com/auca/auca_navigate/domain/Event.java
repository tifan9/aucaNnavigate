package com.auca.auca_navigate.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String eventName;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String hostCampus;
    private String coordinator;
    @Column(length = 1000)
    private String description;
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "studentId")
    private Student student;
    public Event() {
    }

    public Event(String coordinator, String description, LocalDateTime endDateTime, Long eventId, String eventName, String hostCampus, LocalDateTime startDateTime, Student student) {
        this.coordinator = coordinator;
        this.description = description;
        this.endDateTime = endDateTime;
        this.eventId = eventId;
        this.eventName = eventName;
        this.hostCampus = hostCampus;
        this.startDateTime = startDateTime;
        this.student = student;
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

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
