package com.village.locals.village_locals.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.village.locals.village_locals.beans.Event;
import com.village.locals.village_locals.services.EventService;

@RestController
@RequestMapping("/api/event")
public class EventAPI {

    @Autowired
    EventService eventService;

    @PostMapping("/add")
    public int add(@RequestBody Event event) {
        return eventService.add(event);
    }

    @PatchMapping("/update")
    public void update(@RequestBody Event event) {
        eventService.update(event);
    }

    @GetMapping("/getById")
    public Event getById(@RequestParam int eventId) {
        return eventService.getByEventId(eventId);
    }

    @GetMapping("/getAll")
    public List<Event> getAllByOrganizerId(@RequestParam int organizerId) {
        return eventService.getAllByOrganizerId(organizerId);
    }

    @DeleteMapping("/delete")
    public void delete(int eventId) {
        eventService.deleteByEventId(eventId);
    }

}
