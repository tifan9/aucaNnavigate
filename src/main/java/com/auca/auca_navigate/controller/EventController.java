package com.auca.auca_navigate.controller;
import com.auca.auca_navigate.domain.Event;
import com.auca.auca_navigate.domain.Student;
import com.auca.auca_navigate.dto.EventDTO;
import com.auca.auca_navigate.repository.StudentRepo;
import com.auca.auca_navigate.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {
    private final EventService eventService;
    private final StudentRepo studentRepo;
    @Autowired
    public EventController(EventService eventService, StudentRepo studentRepo) {
        this.eventService = eventService;
        this.studentRepo = studentRepo;
    }

    @GetMapping("/all_events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/all_events/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable Long eventId) {
        return eventService.getEventById(eventId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create_events")
    public ResponseEntity<Event> createEvent(@RequestBody EventDTO eventDTO) {
        // Create a new Event object
        Event event = new Event();
        event.setEventName(eventDTO.getEventName());
        event.setStartDateTime(eventDTO.getStartDateTime());
        event.setEndDateTime(eventDTO.getEndDateTime());
        event.setHostCampus(eventDTO.getHostCampus());
        event.setCoordinator(eventDTO.getCoordinator());
        event.setDescription(eventDTO.getDescription());

        // Fetch the Student based on studentId
        Student student = studentRepo.findById(eventDTO.getStudentId()).orElse(null);

        if (student == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Handle the case where the student is not found
        }

        // Set the student in the Event
        event.setStudent(student);

        // Save the Event
        Event savedEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }

    @PutMapping("/update/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long eventId, @RequestBody Event updatedEvent) {
        try {
            Event updated = eventService.updateEvent(eventId, updatedEvent);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }
}
