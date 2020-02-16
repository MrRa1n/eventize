package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.Venue;

import java.util.List;

/**
 * The interface Venues dao.
 */
public interface VenuesDAO {
    /**
     * Gets all venues.
     *
     * @return the all venues
     */
    List<Venue> getAllVenues();

    /**
     * Insert venue.
     *
     * @param venue the venue
     */
    void insertVenue(Venue venue);
}
