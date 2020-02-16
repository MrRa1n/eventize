package dev.tobycook.eventize.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

/**
 * The type Event.
 */
@Entity
@Table(name = "events")
public class Event {

    private long id;
    private String name;
    private String description;
    private Timestamp date;
    private int guestList;
    private int freeList;
    private Venue venue;
    private List<Ticket> tickets;

    /**
     * Gets id.
     *
     * @return the id
     */
    @Id
    @GeneratedValue
    @Column(name = "event_id")
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
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
     * Gets venue.
     *
     * @return the venue
     */
    @JsonBackReference(value = "venue")
    @ManyToOne
    @JoinColumn(name = "venue_id", updatable = false, insertable = false)
    public Venue getVenue() {
        return venue;
    }

    /**
     * Sets venue.
     *
     * @param venue the venue
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    /**
     * Gets tickets.
     *
     * @return the tickets
     */
    @JsonManagedReference(value = "event")
    @OneToMany(targetEntity = Ticket.class, mappedBy = "event", fetch = FetchType.EAGER)
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Sets tickets.
     *
     * @param tickets the tickets
     */
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
