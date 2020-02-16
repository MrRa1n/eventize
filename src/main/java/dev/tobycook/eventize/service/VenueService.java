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
     * Create venue.
     *
     * @param venue the venue
     */
    public void createVenue(Venue venue) {
        if (venue == null) {
            throw new IllegalArgumentException("Venue is null");
        }
        venuesDAO.insertVenue(venue);
    }

    /**
     * Gets all venues.
     *
     * @return the all venues
     */
    public List<Venue> getAllVenues() {
        return venuesDAO.getAllVenues();
    }
}
