package com.auca.auca_navigate.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String hostCampus;
    private String coordinator;
    @Column(length = 1000)
    private String description;

    public Event() {
    }

    public Event(Long id, String eventName, LocalDateTime startDateTime, LocalDateTime endDateTime, String hostCampus, String coordinator, String description) {
        this.id = id;
        this.eventName = eventName;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.hostCampus = hostCampus;
        this.coordinator = coordinator;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getHostCampus() {
        return hostCampus;
    }

    public void setHostCampus(String hostCampus) {
        this.hostCampus = hostCampus;
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
}
