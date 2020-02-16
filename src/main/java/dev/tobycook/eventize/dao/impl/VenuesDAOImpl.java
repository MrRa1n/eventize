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
    @Transactional
    public void insertVenue(Venue venue) {
        try {
            Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info("Inserting new venue...");
                        session.save(venue);
                        return 0;
                    });
        } catch (DataAccessException e) {
            LOGGER.error("Failed to insert venue into database", e);
        }
    }
}
