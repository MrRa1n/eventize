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
     * Gets venue by id.
     *
     * @param venueId the venue id
     * @return the venue by id
     */
    Venue getVenueById(final Long venueId);

    /**
     * Create venue.
     *
     * @param venue the venue
     * @return the venue
     */
    Venue createVenue(final Venue venue);

    /**
     * Update venue venue.
     *
     * @param venue the venue
     * @return the venue
     */
    Venue updateVenue(final Venue venue);

    /**
     * Delete venue.
     *
     * @param venueId the venue id
     */
    void deleteVenue(final Long venueId);
}
