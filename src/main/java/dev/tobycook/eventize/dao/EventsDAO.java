package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.Event;
import dev.tobycook.eventize.model.Ticket;

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
     * Gets all tickets for event.
     *
     * @param eventName the event name
     * @return the all tickets for event
     */
    List<Ticket> getAllTicketsForEvent(final String eventName);

    /**
     * Gets event.
     *
     * @param id the id
     * @return the event
     */
    Event getEvent(long id);
}
