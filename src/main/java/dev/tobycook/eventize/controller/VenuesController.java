package dev.tobycook.eventize.controller;

import dev.tobycook.eventize.dto.VenueDTO;
import dev.tobycook.eventize.model.Venue;
import dev.tobycook.eventize.service.VenueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Venues controller.
 */
@RestController
public class VenuesController {

    private static final Logger LOGGER = LogManager.getLogger(VenuesController.class);

    /* The Venue Service. */
    private VenueService venueService;

    private ModelMapper modelMapper;

    /**
     * Instantiates a new Venues controller.
     *
     * @param venueService the venue service
     * @param modelMapper  the model mapper
     */
    @Autowired
    public VenuesController(VenueService venueService, ModelMapper modelMapper) {
        this.venueService = venueService;
        this.modelMapper = modelMapper;
    }

    /**
     * Gets all venues.
     *
     * @return the all venues
     */
    @GetMapping(value = "/venues")
    public List<Venue> getAllVenues() {
        return venueService.getAllVenues();
    }

    /**
     * Create venue response entity.
     *
     * @param venueDTO the venue dto
     * @return the response entity
     */
    @PostMapping(value = "/venues")
    public ResponseEntity<Void> createVenue(@RequestBody VenueDTO venueDTO) {
        Venue venue = convertToEntity(venueDTO);
        try {
            venueService.createVenue(venue);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Failed to create venue", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private Venue convertToEntity(VenueDTO venueDTO) {
        LOGGER.info("Mapping VenueDTO to Venue...");
        return modelMapper.map(venueDTO, Venue.class);
    }
}
