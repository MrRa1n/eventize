package dev.tobycook.eventize.service;

import dev.tobycook.eventize.dao.TicketsDAO;
import dev.tobycook.eventize.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    /* The Tickets DAO. */
    private final TicketsDAO ticketsDAO;

    @Autowired
    public TicketService(TicketsDAO ticketsDAO) {
        this.ticketsDAO = ticketsDAO;
    }

    public List<Ticket> getAllTickets() {
        return ticketsDAO.getAllTickets();
    }
}
