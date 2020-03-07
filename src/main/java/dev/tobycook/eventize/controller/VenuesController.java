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
 * The type Venues controller.
 */
@RestController
@RequestMapping(value = "/api/venues")
public class VenuesController {

    /* The Logger. */
    private static final Logger LOGGER = LogManager.getLogger(VenuesController.class);

    /* The Venue Service. */
    private VenueService venueService;

    /* The Model Mapper. */
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
    @GetMapping
    public ResponseEntity<List<Venue>> getAllVenues() {
        List<Venue> venues = venueService.getAllVenues();
        return new ResponseEntity<>(venues, HttpStatus.OK);
    }

    /**
     * Create venue response entity.
     *
     * @param venueDTO the venue dto
     * @return the response entity
     */
    @PostMapping(value = "/create")
    public ResponseEntity<Object> createVenue(@RequestBody VenueDTO venueDTO) {
        try {
            Venue venue = venueService.createVenue(convertToEntity(venueDTO));
            return new ResponseEntity<>(venue, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Failed to create venue", e);
            return new ResponseEntity<>("Failed to create venue", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Gets venue by id.
     *
     * @param venueId the venue id
     * @return the venue by id
     */
    @GetMapping(value = "/{venueId}")
    public ResponseEntity<Venue> getVenueById(@PathVariable final Long venueId) {
        Venue venue = venueService.getVenueById(venueId);
        return new ResponseEntity<>(venue, HttpStatus.OK);
    }

    /**
     * Update venue response entity.
     *
     * @param venueDTO the venue dto
     * @return the response entity
     */
    @PutMapping(value = "/update")
    public ResponseEntity<Venue> updateVenue(@RequestBody VenueDTO venueDTO) {
        Venue venue = venueService.updateVenue(convertToEntity(venueDTO));
        return new ResponseEntity<>(venue, HttpStatus.OK);
    }

    /**
     * Delete venue response entity.
     *
     * @param venueId the venue id
     * @return the response entity
     */
    @DeleteMapping(value = "/{venueId}/delete")
    public ResponseEntity<Void> deleteVenue(@PathVariable final Long venueId) {
        venueService.deleteVenue(venueId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Convert the venue DTO.
     *
     * @param venueDTO the venue DTO
     * @return the converted entity
     */
    private Venue convertToEntity(VenueDTO venueDTO) {
        LOGGER.info("Mapping VenueDTO to Venue...");
        return modelMapper.map(venueDTO, Venue.class);
    }
}
