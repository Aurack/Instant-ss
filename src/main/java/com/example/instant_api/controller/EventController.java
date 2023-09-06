package com.example.instant_api.controller;

import com.example.instant_api.entity.Event;
import com.example.instant_api.entity.User;
import com.example.instant_api.service.EventService;
import com.example.instant_api.service.PictureService;
import com.example.instant_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    private final UserService userService;

    private final PictureService pictureService;

    @Autowired
    public EventController(EventService eventService, UserService userService, PictureService pictureService) {
        this.eventService = eventService;
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestParam String name, @RequestParam Long userId) {
        User user = this.userService.getUserById(userId);
        Event newEvent = eventService.createEvent(name, user);
        return ResponseEntity.ok(newEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        Event updatedEvent = eventService.updateEvent(event);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        this.pictureService.getPicturesByEventId(id).forEach(picture -> this.pictureService.deletePicture(picture.getId()));
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
