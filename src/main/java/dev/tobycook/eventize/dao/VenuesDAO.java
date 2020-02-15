package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.Venue;

import java.util.List;

public interface VenuesDAO {
    List<Venue> getAllVenues();
    void insertVenue(Venue venue);
}
