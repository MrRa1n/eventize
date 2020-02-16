package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.Ticket;

import java.util.List;

/**
 * The interface Tickets dao.
 */
public interface TicketsDAO {
    /**
     * Gets all tickets.
     *
     * @return the all tickets
     */
    List<Ticket> getAllTickets();
}
