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
    Event getEventById(final Long id);

    /**
     * Create event.
     *
     * @param event the event
     * @return the event
     */
    Event createEvent(final Event event);

    /**
     * Update event event.
     *
     * @param event the event
     * @return the event
     */
    Event updateEvent(final Event event);

    /**
     * Delete event.
     *
     * @param eventId the event id
     */
    void deleteEvent(final Long eventId);

}
