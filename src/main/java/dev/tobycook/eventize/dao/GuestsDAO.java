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

    /**
     * Gets guest by id.
     *
     * @param guestId the guest id
     * @return the guest by id
     */
    Guest getGuestById(final Long guestId);

    /**
     * Create guest guest.
     *
     * @param guest the guest
     * @return the guest
     */
    Guest createGuest(final Guest guest);

    /**
     * Update guest guest.
     *
     * @param guest the guest
     * @return the guest
     */
    Guest updateGuest(final Guest guest);

    /**
     * Delete guest.
     *
     * @param guestId the guest id
     */
    void deleteGuest(final Long guestId);
}
