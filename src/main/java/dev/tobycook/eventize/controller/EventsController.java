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

/**
 * The type Events controller.
 */
@RestController
public class EventsController {

    /* The Event Service. */
    private EventService eventService;

    /**
     * Instantiates a new Events controller.
     *
     * @param eventService the event service
     */
    @Autowired
    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * Gets event name.
     *
     * @return the event name
     */
    @GetMapping(value = "/events")
    public List<Event> getEventName() {
        return eventService.getAllEvents();
    }

    /**
     * Gets event by id.
     *
     * @param id the id
     * @return the event by id
     */
    @GetMapping(value = "/events/{id}")
    public Event getEventById(@PathVariable final long id) {
        return eventService.getEventById(id);
    }

    /**
     * Gets all tickets for event.
     *
     * @param name the name
     * @return the all tickets for event
     */
    @GetMapping(value = "/eventTickets")
    public List<Ticket> getAllTicketsForEvent(@RequestParam final String name) {
        return eventService.getAllTicketsForEvent(name);
    }
}
