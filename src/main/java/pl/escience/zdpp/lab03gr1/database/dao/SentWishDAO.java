package pl.escience.zdpp.lab03gr1.database.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import pl.escience.zdpp.lab03gr1.database.EntityCRUD;
import pl.escience.zdpp.lab03gr1.database.entity.SentWish;

import java.util.List;

/**
 * <p>SentWishDAO class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
public class SentWishDAO implements EntityCRUD<SentWish> {
    private final SessionFactory sessionFactory;

    /**
     * <p>Constructor for SentWishDAO.</p>
     *
     * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
     */
    public SentWishDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * <p>getEntities.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<SentWish> getEntities() {
        List<SentWish> sentWishes;
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Query<SentWish> theQuery = currentSession.createQuery("from SentWish", SentWish.class);
        sentWishes = theQuery.getResultList();
        currentSession.getTransaction().commit();

        return sentWishes;
    }

    /**
     * <p>saveEntity.</p>
     *
     * @param entity a {@link pl.escience.zdpp.lab03gr1.database.entity.SentWish} object.
     */
    public void saveEntity(SentWish entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(entity);
        currentSession.getTransaction().commit();

    }

    /** {@inheritDoc} */
    public SentWish getEntity(int id) {
        SentWish sentWish;
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        sentWish = currentSession.get(SentWish.class, id);
        currentSession.getTransaction().commit();

        return sentWish;
    }

    /** {@inheritDoc} */
    public void deleteEntity(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.createQuery("delete from SentWish where id=:sentWishId")
                .setParameter("sentWishId", id).executeUpdate();
        currentSession.getTransaction().commit();
    }
}
