package dev.tobycook.eventize.controller;

import dev.tobycook.eventize.dto.EventDTO;
import dev.tobycook.eventize.model.Event;
import dev.tobycook.eventize.service.EventService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Events controller.
 */
@RestController
public class EventsController {

    /* The Logger. */
    private static final Logger LOGGER = LogManager.getLogger(EventsController.class);

    /* The Event Service. */
    private EventService eventService;

    /* The Model Mapper. */
    private ModelMapper modelMapper;

    /**
     * Instantiates a new Events controller.
     *
     * @param eventService the event service
     * @param modelMapper  the model mapper
     */
    @Autowired
    public EventsController(EventService eventService, ModelMapper modelMapper) {
        this.eventService = eventService;
        this.modelMapper = modelMapper;
    }

    /**
     * Gets event name.
     *
     * @return the event name
     */
    @GetMapping(value = "/events")
    public List<Event> getEventName() {
        return eventService.getAllEvents();
    }

    /**
     * Create event response entity.
     *
     * @param eventDTO the event dto
     * @return the response entity
     */
    @PostMapping(value = "/events")
    public ResponseEntity<String> createEvent(@RequestBody EventDTO eventDTO) {
        try {
            Event event = convertToEntity(eventDTO);
            eventService.createEvent(event);
            return new ResponseEntity<>("Successfully created event", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Failed to create event", e);
            return new ResponseEntity<>("Failed to create event", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Gets event by id.
     *
     * @param id the id
     * @return the event by id
     */
    @GetMapping(value = "/events/{id}")
    public Event getEventById(@PathVariable final Long id) {
        return eventService.getEventById(id);
    }

    /**
     * Convert the Event DTO.
     *
     * @param eventDTO the event DTO
     * @return the converted entity
     */
    private Event convertToEntity(EventDTO eventDTO) {
        return modelMapper.map(eventDTO, Event.class);
    }
}
