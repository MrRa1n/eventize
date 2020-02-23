package dev.tobycook.eventize.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The type Ticket.
 */
@Entity
@Table(name = "tickets")
public class Ticket {
    private Long id;
    private String type;
    private Long eventId;
    private Long guestId;

    /**
     * Gets id.
     *
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ticket_id", updatable = false, nullable = false)
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
     * Gets event id.
     *
     * @return the event id
     */
    @Column(name ="event_id")
    public Long getEventId() {
        return eventId;
    }

    /**
     * Sets event id.
     *
     * @param eventId the event id
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    /**
     * Gets guest id.
     *
     * @return the guest id
     */
    @Column(name = "guest_id")
    public Long getGuestId() {
        return guestId;
    }

    /**
     * Sets guest id.
     *
     * @param guestId the guest id
     */
    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }
}
