package dev.tobycook.eventize.service;

import dev.tobycook.eventize.dao.VenuesDAO;
import dev.tobycook.eventize.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Venue service.
 */
@Service
public class VenueService {

    /* The Venues DAO. */
    private final VenuesDAO venuesDAO;

    /**
     * Instantiates a new Venue service.
     *
     * @param venuesDAO the venues dao
     */
    @Autowired
    public VenueService(VenuesDAO venuesDAO) {
        this.venuesDAO = venuesDAO;
    }

    /**
     * Gets all venues.
     *
     * @return the all venues
     */
    public List<Venue> getAllVenues() {
        return venuesDAO.getAllVenues();
    }

    /**
     * Gets venue by id.
     *
     * @param venueId the venue id
     * @return the venue by id
     */
    public Venue getVenueById(final Long venueId) {
        return venuesDAO.getVenueById(venueId);
    }

    /**
     * Create venue.
     *
     * @param venue the venue
     * @return the venue
     */
    public Venue createVenue(Venue venue) {
        if (venue == null) {
            throw new IllegalArgumentException("Venue cannot be null");
        }
        return venuesDAO.createVenue(venue);
    }

    /**
     * Update venue venue.
     *
     * @param venue the venue
     * @return the venue
     */
    public Venue updateVenue(final Venue venue) {
        return venuesDAO.updateVenue(venue);
    }

    /**
     * Delete venue.
     *
     * @param venueId the venue id
     */
    public void deleteVenue(final Long venueId) {
        venuesDAO.deleteVenue(venueId);
    }



}
