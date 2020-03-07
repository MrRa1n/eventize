package dev.tobycook.eventize.service;

import dev.tobycook.eventize.dao.TicketsDAO;
import dev.tobycook.eventize.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Ticket service.
 */
@Service
public class TicketService {

    /* The Tickets DAO. */
    private final TicketsDAO ticketsDAO;

    /**
     * Instantiates a new Ticket service.
     *
     * @param ticketsDAO the tickets dao
     */
    @Autowired
    public TicketService(TicketsDAO ticketsDAO) {
        this.ticketsDAO = ticketsDAO;
    }

    /**
     * Gets all tickets.
     *
     * @return the all tickets
     */
    public List<Ticket> getAllTickets() {
        return ticketsDAO.getAllTickets();
    }

    /**
     * Gets ticket by id.
     *
     * @param ticketId the ticket id
     * @return the ticket by id
     */
    public Ticket getTicketById(final Long ticketId) {
        return ticketsDAO.getTicketById(ticketId);
    }

    /**
     * Create ticket ticket.
     *
     * @param ticket the ticket
     * @return the ticket
     */
    public Ticket createTicket(final Ticket ticket) {
        if (ticket == null)
            throw new IllegalArgumentException("Ticket cannot be null");
        return ticketsDAO.createTicket(ticket);
    }

    /**
     * Update ticket ticket.
     *
     * @param ticket the ticket
     * @return the ticket
     */
    public Ticket updateTicket(final Ticket ticket) {
        if (ticket == null)
            throw new IllegalArgumentException("Ticket cannot be null");
        return ticketsDAO.updateTicket(ticket);
    }

    /**
     * Delete ticket.
     *
     * @param ticketId the ticket id
     */
    public void deleteTicket(final Long ticketId) {
        ticketsDAO.deleteTicket(ticketId);
    }
}
