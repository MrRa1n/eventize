package dev.tobycook.eventize.controller;

import dev.tobycook.eventize.model.Event;
import dev.tobycook.eventize.model.Ticket;
import dev.tobycook.eventize.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventsController {

    /* The Event Service. */
    private EventService eventService;

    @Autowired
    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(value = "/events")
    public List<Event> getEventName() {
        return eventService.getAllEvents();
    }

    @GetMapping(value = "/events/{id}")
    public Event getEventById(@PathVariable final long id) {
        return eventService.getEventById(id);
    }

    @GetMapping(value = "/eventTickets")
    public List<Ticket> getAllTicketsForEvent(@RequestParam final String name) {
        return eventService.getAllTicketsForEvent(name);
    }
}
