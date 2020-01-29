package dev.tobycook.eventize.dao.impl;

import dev.tobycook.eventize.dao.VenuesDAO;
import dev.tobycook.eventize.model.Venue;
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
public class VenuesDAOImpl implements VenuesDAO {

    private static final Logger LOGGER = LogManager.getLogger(VenuesDAOImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public VenuesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Venue> getAllVenues() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            return session.createQuery("FROM Venue").list();
        } catch (HibernateException e) {
            LOGGER.error("Failed to open database session", e);
            return Collections.emptyList();
        }
    }
}
