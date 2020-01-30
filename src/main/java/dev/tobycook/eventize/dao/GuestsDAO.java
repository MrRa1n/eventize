package dev.tobycook.eventize.dao;

import dev.tobycook.eventize.model.Guest;

import java.util.List;

public interface GuestsDAO {
    List<Guest> getAllGuests();
}
