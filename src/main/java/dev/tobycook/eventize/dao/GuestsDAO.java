package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.Guest;

import java.util.List;

/**
 * The interface Guests dao.
 */
public interface GuestsDAO {
    /**
     * Gets all guests.
     *
     * @return the all guests
     */
    List<Guest> getAllGuests();
}
