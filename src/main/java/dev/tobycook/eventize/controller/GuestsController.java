package dev.tobycook.eventize.controller;

import dev.tobycook.eventize.model.Guest;
import dev.tobycook.eventize.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Guests controller.
 */
@RestController
public class GuestsController {

    /* The Guest Service. */
    private GuestService guestService;

    /**
     * Instantiates a new Guests controller.
     *
     * @param guestService the guest service
     */
    @Autowired
    public GuestsController(GuestService guestService) {
        this.guestService = guestService;
    }

    /**
     * Gets all guests.
     *
     * @return the all guests
     */
    @GetMapping(value = "/guests")
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }
}
