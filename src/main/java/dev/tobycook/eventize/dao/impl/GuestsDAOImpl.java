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
    @Autowired
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
}
