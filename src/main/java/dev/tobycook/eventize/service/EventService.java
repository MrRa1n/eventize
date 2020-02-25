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
        return eventsDAO.getEventById(id);
    }

    /**
     * Create event.
     *
     * @param event the event
     * @return the event
     */
    public Event createEvent(Event event) {
        if (event == null)
            throw new IllegalArgumentException("Event cannot be null");
        return eventsDAO.createEvent(event);
    }

    /**
     * Update event event.
     *
     * @param event the event
     * @return the event
     */
    public Event updateEvent(Event event) {
        if (event == null)
            throw new IllegalArgumentException("Event cannot be null");
        return eventsDAO.updateEvent(event);
    }

    /**
     * Delete event.
     *
     * @param eventId the event id
     */
    public void deleteEvent(final Long eventId) {
        eventsDAO.deleteEvent(eventId);
    }
}
