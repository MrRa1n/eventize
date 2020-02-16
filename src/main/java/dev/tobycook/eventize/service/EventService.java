package dev.tobycook.eventize.service;

import dev.tobycook.eventize.dao.EventsDAO;
import dev.tobycook.eventize.model.Event;
import dev.tobycook.eventize.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Event service.
 */
@Service
public class EventService {

    private EventsDAO eventsDAO;

    /**
     * Instantiates a new Event service.
     *
     * @param eventsDAO the events dao
     */
    @Autowired
    public EventService(EventsDAO eventsDAO) {
        this.eventsDAO = eventsDAO;
    }

    /**
     * Gets all events.
     *
     * @return the all events
     */
    public List<Event> getAllEvents() {
        return eventsDAO.getAllEvents();
    }

    /**
     * Gets all tickets for event.
     *
     * @param eventName the event name
     * @return the all tickets for event
     */
    public List<Ticket> getAllTicketsForEvent(final String eventName) {
        return eventsDAO.getAllTicketsForEvent(eventName);
    }

    /**
     * Gets event by id.
     *
     * @param id the id
     * @return the event by id
     */
    public Event getEventById(long id) {
        return eventsDAO.getEvent(id);
    }
}
