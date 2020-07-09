package dev.tobycook.eventize.dao.impl;

import dev.tobycook.eventize.dao.UsersDAO;
import dev.tobycook.eventize.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Objects;

/**
 * The type Users dao.
 */
@Repository
public class UsersDAOImpl extends HibernateDaoSupport implements UsersDAO {

    /* The logger. */
    private static final Logger LOGGER = LogManager.getLogger(UsersDAOImpl.class);

    /**
     * Instantiates a new Users dao.
     *
     * @param sessionFactory the session factory
     */
    @Autowired
    public UsersDAOImpl(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public User findByUsername(String username) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        Query<User> query = session.createQuery("FROM User WHERE username = :username")
                                .setParameter("username", username);
                        return query.uniqueResult();
                    });
        } catch (DataAccessException e) {
            LOGGER.error("Failed to find user {}", username);
            return null;
        }
    }

    @Override
    @Transactional
    public User registerUser(User userDetails) {
        try {
            return Objects.requireNonNull(getHibernateTemplate())
                    .execute((final Session session) -> {
                        session.save(userDetails);
                        return userDetails;
                    });
        } catch (DataAccessException e) {
            LOGGER.error("Failed to register user {}", userDetails.getUsername());
            return null;
        }
    }
}
