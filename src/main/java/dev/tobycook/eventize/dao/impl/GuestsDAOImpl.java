package dev.tobycook.eventize.dao.impl;

import dev.tobycook.eventize.dao.GuestsDAO;
import dev.tobycook.eventize.model.Guest;
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
public class GuestsDAOImpl implements GuestsDAO {

    /* The Logger. */
    private static final Logger LOGGER = LogManager.getLogger(GuestsDAOImpl.class);

    /* The Session Factory. */
    private SessionFactory sessionFactory;

    @Autowired
    public GuestsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Guest> getAllGuests() {
        LOGGER.info("Called: getAllGuests()");
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            return session.createQuery("FROM Guest").list();
        } catch (HibernateException e) {
            LOGGER.error("Failed to open database session", e);
            return Collections.emptyList();
        }
    }
}
