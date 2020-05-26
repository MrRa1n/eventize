package dev.tobycook.eventize.dao.impl;

import dev.tobycook.eventize.dao.UsersDAO;
import dev.tobycook.eventize.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Objects;

@Repository
public class UsersDAOImpl extends HibernateDaoSupport implements UsersDAO {

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
            return null;
        }
    }
}
