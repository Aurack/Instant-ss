package com.example.instant_api.service;

import com.example.instant_api.entity.Event;
import com.example.instant_api.entity.User;
import com.example.instant_api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository EventRepository) {
        this.eventRepository = EventRepository;
    }

    public List<Event> getAllEvents() {
        return this.eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return this.eventRepository.findById(id).orElse(null);
    }

    public Event getEventByName(String name) {
        return this.eventRepository.findByName(name).orElse(null);
    }

    public Event createEvent(Event event) {
        return this.eventRepository.save(event);
    }

    public Event createEventByNameAndUser(String name, User user) {
        Event event = new Event(name, user);
        return this.eventRepository.save(event);
    }

    public Event updateEvent(Event Event) {
        return this.eventRepository.save(Event);
    }

    public void deleteEvent(Long id) {
        this.eventRepository.deleteById(id);
    }
}
