package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.Event;
import dev.tobycook.eventize.model.Ticket;

import java.util.List;

public interface EventsDAO {
    List<Event> getAllEvents();
    List<Ticket> getAllTicketsForEvent(final String eventName);
}
