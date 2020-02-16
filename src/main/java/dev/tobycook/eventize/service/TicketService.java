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
}
