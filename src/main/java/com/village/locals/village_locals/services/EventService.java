package com.village.locals.village_locals.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.village.locals.village_locals.beans.Event;
import com.village.locals.village_locals.repositories.EventRepository;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public int add(Event event) {
        // TODO :: VALIDATIONS
        eventRepository.save(event);
        return event.getEventId();
    }

    public void update(Event event) {
        // TODO :: VALIDATIONS
        eventRepository.save(event);
    }

    public List<Event> getAllByOrganizerId(int organizerId) {
        List<Event> events = eventRepository.findAllByOrganizerOrganizerId(organizerId);
        if (events == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return events;
    }

    public Event getByEventId(int eventId) {
        Event event = eventRepository.findByEventId(eventId);
        if (event == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return event;
    }

    public void deleteByEventId(int eventId) {
        // TODO :: VALIDATIONS
        eventRepository.deleteById(eventId);
    }
}
