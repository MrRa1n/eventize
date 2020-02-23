package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.Event;

import java.util.List;

/**
 * The interface Events dao.
 */
public interface EventsDAO {
    /**
     * Gets all events.
     *
     * @return the all events
     */
    List<Event> getAllEvents();

    /**
     * Gets event.
     *
     * @param id the id
     * @return the event
     */
    Event getEvent(final Long id);

    /**
     * Create event.
     *
     * @param event the event
     */
    void createEvent(final Event event);
}
