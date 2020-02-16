package dev.tobycook.eventize.service;

import dev.tobycook.eventize.dao.GuestsDAO;
import dev.tobycook.eventize.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Guest service.
 */
@Service
public class GuestService {

    /* The Guests DAO. */
    private final GuestsDAO guestsDAO;

    /**
     * Instantiates a new Guest service.
     *
     * @param guestsDAO the guests dao
     */
    @Autowired
    public GuestService(GuestsDAO guestsDAO) {
        this.guestsDAO = guestsDAO;
    }

    /**
     * Gets all guests.
     *
     * @return the all guests
     */
    public List<Guest> getAllGuests() {
        return guestsDAO.getAllGuests();
    }
}
