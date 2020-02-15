package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.Event;
import dev.tobycook.eventize.model.Ticket;

import java.util.List;

public interface EventsDAO {
    List<Event> getAllEvents();
    List<Ticket> getAllTicketsForEvent(final String eventName);

    Event getEvent(long id);
//    void createEvent(Event event);
//    void updateEvent(Event event);
//    void deleteEvent(long id);

}
