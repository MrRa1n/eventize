package dev.tobycook.eventize.service;

import dev.tobycook.eventize.dao.VenuesDAO;
import dev.tobycook.eventize.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {

    private final VenuesDAO venuesDAO;

    @Autowired
    public VenueService(VenuesDAO venuesDAO) {
        this.venuesDAO = venuesDAO;
    }

    public List<Venue> getAllVenues() {
        return venuesDAO.getAllVenues();
    }
}
