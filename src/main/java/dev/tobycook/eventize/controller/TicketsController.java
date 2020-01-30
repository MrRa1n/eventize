package dev.tobycook.eventize.controller;

import dev.tobycook.eventize.model.Ticket;
import dev.tobycook.eventize.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketsController {

    /* The Ticket Service. */
    private TicketService ticketService;

    @Autowired
    public TicketsController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(value = "/tickets")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }
}
