package dev.tobycook.eventize.dao.impl;

import dev.tobycook.eventize.dao.VenuesDAO;
import dev.tobycook.eventize.model.Venue;
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
 * The type Venues dao.
 */
@Repository
public class VenuesDAOImpl extends HibernateDaoSupport implements VenuesDAO {

    /* The Logger. */
    private static final Logger LOGGER = LogManager.getLogger(VenuesDAOImpl.class);

    /**
     * Instantiates a new Venues dao.
     *
     * @param sessionFactory the session factory
     */
    @Autowired
    public VenuesDAOImpl(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Venue> getAllVenues() {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) ->
                            session.createQuery("FROM Venue").list());
        } catch (DataAccessException e) {
            LOGGER.error("Failed to fetch list of venues from database", e);
            return Collections.emptyList();
        }
    }

    @Override
    public Venue getVenueById(final Long venueId) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info(String.format("Fetching venue with ID: %d", venueId));
                        return (Venue) session.createQuery("FROM Venue v WHERE v.id = :venueId")
                                .setParameter("venueId", venueId)
                                .uniqueResult();
                    });
        } catch (DataAccessException e) {
            LOGGER.error(String.format("Failed to fetch venue with ID: %d", venueId));
            return null;
        }
    }

    @Override
    @Transactional
    public Venue createVenue(final Venue venue) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info("Creating venue...");
                        session.save(venue);
                        return venue;
                    });
        } catch (DataAccessException e) {
            LOGGER.error("Failed to create venue", e);
            return null;
        }
    }

    @Override
    @Transactional
    public Venue updateVenue(final Venue venue) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info("Updating venue...");
                        session.update(venue);
                        return venue;
                    });
        } catch (DataAccessException e) {
            LOGGER.error("Failed to update venue", e);
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteVenue(final Long venueId) {
        try {
            Venue venue = getVenueById(venueId);
            if (venue == null) {
                throw new NullPointerException("Failed to find venue");
            }
            Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info("Deleting venue...");
                        session.delete(venue);
                        return 0;
                    });
        } catch (DataAccessException e) {
            LOGGER.error("Failed to delete venue", e);
        }
    }
}
