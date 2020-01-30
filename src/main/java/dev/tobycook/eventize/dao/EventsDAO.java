package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.Event;

import java.util.List;

public interface EventsDAO {
    List<Event> getAllEvents();
}
