package dev.tobycook.eventize.controller;

import dev.tobycook.eventize.model.Ticket;
import dev.tobycook.eventize.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Tickets controller.
 */
@RestController
public class TicketsController {

    /* The Ticket Service. */
    private TicketService ticketService;

    /**
     * Instantiates a new Tickets controller.
     *
     * @param ticketService the ticket service
     */
    @Autowired
    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * Gets all tickets.
     *
     * @return the all tickets
     */
    @GetMapping(value = "/tickets")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }
}
