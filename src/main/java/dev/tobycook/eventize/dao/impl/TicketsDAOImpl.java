package dev.tobycook.eventize.dao.impl;

import dev.tobycook.eventize.dao.TicketsDAO;
import dev.tobycook.eventize.model.Ticket;
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
public class TicketsDAOImpl implements TicketsDAO {

    /* The Logger. */
    private static final Logger LOGGER = LogManager.getLogger(TicketsDAOImpl.class);

    /* The Session Factory. */
    private SessionFactory sessionFactory;

    @Autowired
    public TicketsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ticket> getAllTickets() {
        LOGGER.info("Called: getAllTickets()");
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            return session.createQuery("FROM Ticket").list();
        } catch (HibernateException e) {
            LOGGER.error("Failed to open database session", e);
            return Collections.emptyList();
        }
    }
}
