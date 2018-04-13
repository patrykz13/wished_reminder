package pl.escience.zdpp.lab03gr1.database.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import pl.escience.zdpp.lab03gr1.database.EntityCRUD;
import pl.escience.zdpp.lab03gr1.database.entity.User;
import pl.escience.zdpp.lab03gr1.database.exception.UniqueViolationException;

import javax.persistence.NoResultException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * <p>UserDAO class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
public class UserDAO implements EntityCRUD<User> {
    private final SessionFactory sessionFactory;

    /**
     * <p>Constructor for UserDAO.</p>
     *
     * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
     */
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * <p>getEntities.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<User> getEntities() {
        List<User> users;
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Query<User> theQuery = currentSession.createQuery("from User", User.class);
        users = theQuery.getResultList();
        currentSession.getTransaction().commit();

        return users;
    }

    /**
     * <p>saveEntity.</p>
     *
     * @param entity a {@link pl.escience.zdpp.lab03gr1.database.entity.User} object.
     * @throws pl.escience.zdpp.lab03gr1.database.exception.UniqueViolationException if any.
     */
    public void saveEntity(User entity) throws UniqueViolationException {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
        try {
            currentSession.saveOrUpdate(entity);
            currentSession.getTransaction().commit();
        }
        catch (ConstraintViolationException e){
            Throwable eCause = e.getCause();
            currentSession.close();
            while ((eCause != null) && !(eCause instanceof SQLIntegrityConstraintViolationException))
                eCause = eCause.getCause();
            if (eCause != null) {
                Throwable exceptionCause;
                exceptionCause = new Throwable("podany login już istnieje");
                throw new UniqueViolationException("Błąd bazy danych", exceptionCause);
            }
        }
    }

    /** {@inheritDoc} */
    public User getEntity(int id) {
        User user;
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        user = currentSession.get(User.class, id);
        currentSession.getTransaction().commit();

        return user;
    }

    /**
     * <p>getEntityByLogin.</p>
     *
     * @param login a {@link java.lang.String} object.
     * @return a {@link pl.escience.zdpp.lab03gr1.database.entity.User} object.
     */
    public User getEntityByLogin(String login) {
        User user;
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        try {
            user = currentSession.createQuery("from User where login=:userLogin", User.class)
                    .setParameter("userLogin", login).getSingleResult();
            currentSession.getTransaction().commit();
        } catch (NoResultException e) {
            currentSession.close();
            throw e;
        }
        return user;
    }

    /** {@inheritDoc} */
    public void deleteEntity(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.createQuery("delete from User where id=:userId")
                .setParameter("userId", id).executeUpdate();
        currentSession.getTransaction().commit();
    }
}
