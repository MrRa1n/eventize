package dev.tobycook.eventize.controller;

import dev.tobycook.eventize.dto.TicketDTO;
import dev.tobycook.eventize.model.Ticket;
import dev.tobycook.eventize.service.TicketService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Tickets controller.
 */
@RestController
@RequestMapping(value = "/tickets")
public class TicketsController {

    /* The Logger. */
    private static final Logger LOGGER = LogManager.getLogger(TicketsController.class);

    /* The Ticket Service. */
    private TicketService ticketService;

    /* The Model Mapper. */
    private ModelMapper modelMapper;

    /**
     * Instantiates a new Tickets controller.
     *
     * @param ticketService the ticket service
     * @param modelMapper   the model mapper
     */
    @Autowired
    public TicketsController(TicketService ticketService, ModelMapper modelMapper) {
        this.ticketService = ticketService;
        this.modelMapper = modelMapper;
    }

    /**
     * Gets all tickets.
     *
     * @return the all tickets
     */
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    /**
     * Create ticket response entity.
     *
     * @param ticketDTO the ticket dto
     * @return the response entity
     */
    @PostMapping(value = "/create")
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketDTO ticketDTO) {
        try {
            Ticket ticket = ticketService.createTicket(convertToEntity(ticketDTO));
            return new ResponseEntity<>(ticket, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Failed to create ticket");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Gets ticket by id.
     *
     * @param ticketId the ticket id
     * @return the ticket by id
     */
    @GetMapping(value = "/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable final Long ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    /**
     * Update ticket response entity.
     *
     * @param ticketDTO the ticket dto
     * @return the response entity
     */
    @PutMapping(value = "/update")
    public ResponseEntity<Ticket> updateTicket(@RequestBody TicketDTO ticketDTO) {
        try {
            Ticket ticket = ticketService.updateTicket(convertToEntity(ticketDTO));
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Failed to update ticket");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Delete ticket response entity.
     *
     * @param ticketId the ticket id
     * @return the response entity
     */
    @DeleteMapping(value = "/{ticketId}/delete")
    public ResponseEntity<Void> deleteTicket(@PathVariable final Long ticketId) {
        ticketService.deleteTicket(ticketId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Convert the Ticket DTO.
     *
     * @param ticketDTO the ticket DTO
     * @return the converted entity
     */
    private Ticket convertToEntity(TicketDTO ticketDTO) {
        return modelMapper.map(ticketDTO, Ticket.class);
    }
}
