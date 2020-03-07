package dev.tobycook.eventize.dao.impl;

import dev.tobycook.eventize.dao.TicketsDAO;
import dev.tobycook.eventize.model.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The type Tickets dao.
 */
@Repository
public class TicketsDAOImpl extends HibernateDaoSupport implements TicketsDAO {

    /* The Logger. */
    private static final Logger LOGGER = LogManager.getLogger(TicketsDAOImpl.class);

    /**
     * Instantiates a new Tickets dao.
     *
     * @param sessionFactory the session factory
     */
    @Autowired
    public TicketsDAOImpl(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ticket> getAllTickets() {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) ->
                            session.createQuery("FROM Ticket").list());
        } catch (DataAccessException e) {
            LOGGER.error("Failed to fetch list of tickets", e);
            return Collections.emptyList();
        }
    }

    @Override
    public Ticket getTicketById(final Long ticketId) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info(String.format("Fetching ticket with ID: %d", ticketId));
                        return (Ticket) session.createQuery("FROM Ticket WHERE id = :ticketId")
                                .setParameter("ticketId", ticketId)
                                .uniqueResult();
                    });
        } catch (DataAccessException e) {
            LOGGER.error(String.format("Failed to fetch ticket with ID: %d", ticketId));
            return null;
        }
    }

    @Override
    @Transactional
    public Ticket createTicket(final Ticket ticket) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info("Creating ticket...");
                        session.save(ticket);
                        return ticket;
                    });
        } catch (DataAccessException e) {
            LOGGER.error("Failed to create ticket", e);
            return null;
        }
    }

    @Override
    @Transactional
    public Ticket updateTicket(final Ticket ticket) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info("Updating ticket...");
                        session.update(ticket);
                        return ticket;
                    });
        } catch (DataAccessException e) {
            LOGGER.error("Failed to update ticket", e);
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteTicket(final Long ticketId) {
        try {
            Ticket ticket = getTicketById(ticketId);
            if (ticket == null)
                throw new NullPointerException("Failed to find ticket");
            Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info("Deleting ticket...");
                        session.delete(ticket);
                        return 0;
                    });
        } catch (DataAccessException e) {
            LOGGER.error("Failed to delete ticket", e);
        }
    }
}
