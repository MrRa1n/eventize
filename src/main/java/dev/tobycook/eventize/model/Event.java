package dev.tobycook.eventize.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {
    private int id;
    private String name;
    private String description;
    private Timestamp date;
    private int guestList;
    private int freeList;
    private Venue venue;
    private List<Ticket> tickets;

    @Id
    @Column(name = "event_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "event_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "event_desc")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "event_date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getGuestList() {
        return guestList;
    }

    public void setGuestList(int guestList) {
        this.guestList = guestList;
    }

    public int getFreeList() {
        return freeList;
    }

    public void setFreeList(int freeList) {
        this.freeList = freeList;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "venue_id", updatable = false, insertable = false)
    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @JsonBackReference
    @OneToMany(targetEntity = Ticket.class, mappedBy = "event", fetch = FetchType.EAGER)
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
