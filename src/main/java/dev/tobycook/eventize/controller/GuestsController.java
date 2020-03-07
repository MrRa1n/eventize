package dev.tobycook.eventize.controller;

import dev.tobycook.eventize.dto.GuestDTO;
import dev.tobycook.eventize.model.Guest;
import dev.tobycook.eventize.service.GuestService;
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
 * The type Guests controller.
 */
@RestController
@RequestMapping(value = "/guests")
public class GuestsController {

    /* The Logger. */
    private static final Logger LOGGER = LogManager.getLogger(GuestsController.class);

    /* The Guest Service. */
    private GuestService guestService;

    /* The Model Mapper. */
    private ModelMapper modelMapper;

    /**
     * Instantiates a new Guests controller.
     *
     * @param guestService the guest service
     * @param modelMapper  the model mapper
     */
    @Autowired
    public GuestsController(GuestService guestService, ModelMapper modelMapper) {
        this.guestService = guestService;
        this.modelMapper = modelMapper;
    }

    /**
     * Gets all guests.
     *
     * @return the all guests
     */
    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    /**
     * Create guest response entity.
     *
     * @param guestDTO the guest dto
     * @return the response entity
     */
    @PostMapping(value = "/create")
    public ResponseEntity<Guest> createGuest(@RequestBody GuestDTO guestDTO) {
        try {
            Guest guest = guestService.createGuest(convertToEntity(guestDTO));
            return new ResponseEntity<>(guest, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Failed to create guest", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Gets guest by id.
     *
     * @param guestId the guest id
     * @return the guest by id
     */
    @GetMapping(value = "/{guestId}")
    public ResponseEntity<Guest> getGuestById(@PathVariable final Long guestId) {
        Guest guest = guestService.getGuestById(guestId);
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }

    /**
     * Update guest response entity.
     *
     * @param guestDTO the guest dto
     * @return the response entity
     */
    @PutMapping(value = "/update")
    public ResponseEntity<Guest> updateGuest(@RequestBody GuestDTO guestDTO) {
        try {
            Guest guest = guestService.updateGuest(convertToEntity(guestDTO));
            return new ResponseEntity<>(guest, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Failed to update guest", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Delete guest response entity.
     *
     * @param guestId the guest id
     * @return the response entity
     */
    @DeleteMapping(value = "/{guestId}/delete")
    public ResponseEntity<Void> deleteGuest(@PathVariable final Long guestId) {
        guestService.deleteGuest(guestId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Guest convertToEntity(GuestDTO guestDTO) {
        return modelMapper.map(guestDTO, Guest.class);
    }
}
