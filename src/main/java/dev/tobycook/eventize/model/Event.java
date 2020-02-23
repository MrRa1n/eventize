package dev.tobycook.eventize.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * The type Event.
 */
@Entity
@Table(name = "events")
public class Event {
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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "event_id", updatable = false, nullable = false)
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
    @Column(name = "event_name")
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
    @Column(name = "event_desc")
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
    @Column(name = "event_date")
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
    @Column(name = "venue_id")
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
