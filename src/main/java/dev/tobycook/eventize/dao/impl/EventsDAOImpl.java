package dev.tobycook.eventize.dao.impl;

import dev.tobycook.eventize.dao.EventsDAO;
import dev.tobycook.eventize.model.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class EventsDAOImpl implements EventsDAO {

    /* The Logger. */
    private static final Logger LOGGER = LogManager.getLogger(EventsDAOImpl.class);

    /* The Session Factory. */
    private SessionFactory sessionFactory;

    @Autowired
    public EventsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Event> getAllEvents() {
        LOGGER.info("Called: getAllEvents()");
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            return session.createQuery("FROM Event").list();
        } catch (HibernateException e) {
            LOGGER.error("Failed to open database session", e);
            return Collections.emptyList();
        }
    }
}
