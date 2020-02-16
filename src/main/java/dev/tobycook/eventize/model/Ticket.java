package dev.tobycook.eventize.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The type Ticket.
 */
@Entity
@Table(name = "tickets")
public class Ticket {
    private int id;
    private String type;
    private Event event;
    private Guest guest;

    /**
     * Gets id.
     *
     * @return the id
     */
    @Id
    @Column(name = "ticket_id")
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @Column(name = "ticket_type")
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets event.
     *
     * @return the event
     */
    @JsonBackReference(value = "event")
    @ManyToOne
    @JoinColumn(name = "event_id", updatable = false, insertable = false)
    public Event getEvent() {
        return event;
    }

    /**
     * Sets event.
     *
     * @param event the event
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * Gets guest.
     *
     * @return the guest
     */
    @JsonBackReference(value = "guest")
    @ManyToOne
    @JoinColumn(name = "guest_id", updatable = false, insertable = false)
    public Guest getGuest() {
        return guest;
    }

    /**
     * Sets guest.
     *
     * @param guest the guest
     */
    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
