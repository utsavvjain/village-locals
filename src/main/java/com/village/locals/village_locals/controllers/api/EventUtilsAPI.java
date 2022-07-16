package com.village.locals.village_locals.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.village.locals.village_locals.beans.EventType;
import com.village.locals.village_locals.beans.Locality;
import com.village.locals.village_locals.services.EventService;

@RestController
@RequestMapping("api/utils")
public class EventUtilsAPI {
    @Autowired
    EventService eventService;

    @GetMapping("/localities")
    public List<Locality> getLocalities() {
        return eventService.getLocalities();
    }

    @GetMapping("/event-types")
    public List<EventType> getEventTypes() {
        return eventService.getEventTypes();
    }
}
