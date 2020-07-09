package dev.tobycook.eventize.dao.impl;

import dev.tobycook.eventize.dao.GuestsDAO;
import dev.tobycook.eventize.model.Guest;
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
 * The type Guests dao.
 */
@Repository
public class GuestsDAOImpl extends HibernateDaoSupport implements GuestsDAO {

    /* The Logger. */
    private static final Logger LOGGER = LogManager.getLogger(GuestsDAOImpl.class);

    /**
     * Instantiates a new Guests dao.
     *
     * @param sessionFactory the session factory
     */
    public GuestsDAOImpl(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Guest> getAllGuests() {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) ->
                            session.createQuery("FROM Guest").list());
        } catch (DataAccessException e) {
            LOGGER.error("Failed to fetch list of guests", e);
            return Collections.emptyList();
        }
    }

    @Override
    public Guest getGuestById(final Long guestId) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info(String.format("Fetching guest with ID: %d", guestId));
                        return (Guest) session.createQuery("FROM Guest g WHERE g.id = :guestId")
                                .setParameter("guestId", guestId)
                                .uniqueResult();
                    });
        } catch (DataAccessException e) {
            LOGGER.error(String.format("Failed to fetch guest with ID: %d", guestId));
            return null;
        }
    }

    @Override
    @Transactional
    public Guest createGuest(final Guest guest) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info("Creating guest...");
                        session.save(guest);
                        return guest;
                    });
        } catch (DataAccessException e) {
            LOGGER.error("Failed to create guest", e);
            return null;
        }
    }

    @Override
    @Transactional
    public Guest updateGuest(final Guest guest) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info(String.format("Updating guest with ID: %d", guest.getId()));
                        session.update(guest);
                        return guest;
                    });
        } catch (DataAccessException e) {
            LOGGER.error(String.format("Failed to update guest with ID: %d", guest.getId()), e);
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteGuest(final Long guestId) {
        try {
            Guest guest = getGuestById(guestId);
            if (guest == null)
                throw new NullPointerException(String.format("Failed to find guest with ID: %d", guestId));
            Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        LOGGER.info(String.format("Deleting guest with ID: %d", guestId));
                        session.delete(guest);
                        return 0;
                    });
        } catch (DataAccessException e) {
            LOGGER.error(String.format("Failed to delete guest with ID: %d", guestId));
        }
    }
}
