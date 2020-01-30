package dev.tobycook.eventize.service;

import dev.tobycook.eventize.dao.GuestsDAO;
import dev.tobycook.eventize.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    /* The Guests DAO. */
    private final GuestsDAO guestsDAO;

    @Autowired
    public GuestService(GuestsDAO guestsDAO) {
        this.guestsDAO = guestsDAO;
    }

    public List<Guest> getAllGuests() {
        return guestsDAO.getAllGuests();
    }
}
