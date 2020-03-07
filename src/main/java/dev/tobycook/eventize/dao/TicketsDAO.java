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

    /**
     * Gets ticket by id.
     *
     * @param ticketId the ticket id
     * @return the ticket by id
     */
    Ticket getTicketById(final Long ticketId);

    /**
     * Create ticket ticket.
     *
     * @param ticket the ticket
     * @return the ticket
     */
    Ticket createTicket(final Ticket ticket);

    /**
     * Update ticket ticket.
     *
     * @param ticket the ticket
     * @return the ticket
     */
    Ticket updateTicket(final Ticket ticket);

    /**
     * Delete ticket.
     *
     * @param ticketId the ticket id
     */
    void deleteTicket(final Long ticketId);
}
