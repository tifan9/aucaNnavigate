package com.auca.auca_navigate.service;

import com.auca.auca_navigate.domain.Event;
import com.auca.auca_navigate.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepo.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepo.save(event);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        return eventRepo.findById(id).map(event -> {
            event.setEventName(updatedEvent.getEventName());
            event.setStartDateTime(updatedEvent.getStartDateTime());
            event.setEndDateTime(updatedEvent.getEndDateTime());
            event.setHostCampus(updatedEvent.getHostCampus());
            event.setCoordinator(updatedEvent.getCoordinator());
            event.setDescription(updatedEvent.getDescription());
            return eventRepo.save(event);
        }).orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    }

    public void deleteEvent(Long id) {
        eventRepo.deleteById(id);
    }
}
