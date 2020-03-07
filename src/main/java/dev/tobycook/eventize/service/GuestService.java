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

    /**
     * Gets guest by id.
     *
     * @param guestId the guest id
     * @return the guest by id
     */
    public Guest getGuestById(final Long guestId) {
        return guestsDAO.getGuestById(guestId);
    }

    /**
     * Create guest guest.
     *
     * @param guest the guest
     * @return the guest
     */
    public Guest createGuest(final Guest guest) {
        if (guest == null)
            throw new IllegalArgumentException("Guest cannot be null");
        return guestsDAO.createGuest(guest);
    }

    /**
     * Update guest guest.
     *
     * @param guest the guest
     * @return the guest
     */
    public Guest updateGuest(final Guest guest) {
        if (guest == null)
            throw new IllegalArgumentException("Guest cannot be null");
        return guestsDAO.updateGuest(guest);
    }

    /**
     * Delete guest.
     *
     * @param guestId the guest id
     */
    public void deleteGuest(final Long guestId) {
        guestsDAO.deleteGuest(guestId);
    }
}
