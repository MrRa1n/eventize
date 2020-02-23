package dev.tobycook.eventize.dto;

import java.sql.Timestamp;

/**
 * The type Event dto.
 */
public class EventDTO {
    private Long id;
    private String name;
    private String description;
    private Timestamp date;
    private int guestList;
    private int freeList;
    private Long venueId;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * Gets guest list.
     *
     * @return the guest list
     */
    public int getGuestList() {
        return guestList;
    }

    /**
     * Sets guest list.
     *
     * @param guestList the guest list
     */
    public void setGuestList(int guestList) {
        this.guestList = guestList;
    }

    /**
     * Gets free list.
     *
     * @return the free list
     */
    public int getFreeList() {
        return freeList;
    }

    /**
     * Sets free list.
     *
     * @param freeList the free list
     */
    public void setFreeList(int freeList) {
        this.freeList = freeList;
    }

    /**
     * Gets venue id.
     *
     * @return the venue id
     */
    public Long getVenueId() {
        return venueId;
    }

    /**
     * Sets venue id.
     *
     * @param venueId the venue id
     */
    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }
}
