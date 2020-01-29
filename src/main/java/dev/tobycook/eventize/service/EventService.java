package dev.tobycook.eventize.service;

import dev.tobycook.eventize.dao.EventsDAO;
import dev.tobycook.eventize.model.Event;
import dev.tobycook.eventize.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private EventsDAO eventsDAO;

    @Autowired
    public EventService(EventsDAO eventsDAO) {
        this.eventsDAO = eventsDAO;
    }

    public List<Event> getAllEvents() {
        return eventsDAO.getAllEvents();
    }

    public List<Ticket> getAllTicketsForEvent(final String eventName) {
        return eventsDAO.getAllTicketsForEvent(eventName);
    }
}
