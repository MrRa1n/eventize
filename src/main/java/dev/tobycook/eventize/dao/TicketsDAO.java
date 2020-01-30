package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.Ticket;

import java.util.List;

public interface TicketsDAO {
    List<Ticket> getAllTickets();
}
