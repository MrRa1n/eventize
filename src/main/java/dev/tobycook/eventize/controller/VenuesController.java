package dev.tobycook.eventize.controller;

import dev.tobycook.eventize.model.Venue;
import dev.tobycook.eventize.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenuesController {

    private VenueService venueService;

    @Autowired
    public VenuesController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping(value = "/venues")
    public List<Venue> getAllVenues() {
        return venueService.getAllVenues();
    }
}
