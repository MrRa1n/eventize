package dev.tobycook.eventize.service;

import dev.tobycook.eventize.dao.EventsDAO;
import dev.tobycook.eventize.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Event service.
 */
@Service
public class EventService {

    /* The Events DAO. */
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
     * Gets event by id.
     *
     * @param id the id
     * @return the event by id
     */
    public Event getEventById(final Long id) {
        return eventsDAO.getEvent(id);
    }

    /**
     * Create event.
     *
     * @param event the event
     */
    public void createEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        eventsDAO.createEvent(event);
    }
}
