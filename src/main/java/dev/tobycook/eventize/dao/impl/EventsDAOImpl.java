package dev.tobycook.eventize.dao.impl;

import dev.tobycook.eventize.dao.EventsDAO;
import dev.tobycook.eventize.model.Event;
import dev.tobycook.eventize.model.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The type Events dao.
 */
@Repository
public class EventsDAOImpl extends HibernateDaoSupport implements EventsDAO {

    /* The Logger. */
    private static final Logger LOGGER = LogManager.getLogger(EventsDAOImpl.class);

    /**
     * Instantiates a new Events dao.
     *
     * @param sessionFactory the session factory
     */
    @Autowired
    public EventsDAOImpl(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> getAllEvents() {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) ->
                            session.createQuery("FROM Event").list());
        } catch (DataAccessException e) {
            LOGGER.error("Failed to fetch list of events from database", e);
            return Collections.emptyList();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ticket> getAllTicketsForEvent(final String eventName) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) ->
                            session.createQuery("SELECT e.tickets FROM Event e WHERE e.name = :eventName")
                            .setParameter("eventName", eventName).list());
        } catch (DataAccessException e) {
            LOGGER.error("Failed to fetch list of event tickets from database", e);
            return Collections.emptyList();
        }
    }

    @Override
    public Event getEvent(final long id) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) ->
                    (Event) session.createQuery("FROM Event e WHERE e.id = :id")
                            .setParameter("id", id).uniqueResult());
        } catch (DataAccessException e) {
            LOGGER.error("Failed to fetch event from database", e);
            return null;
        }
    }
}
