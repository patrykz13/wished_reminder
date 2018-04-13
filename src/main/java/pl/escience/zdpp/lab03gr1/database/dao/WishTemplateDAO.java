package pl.escience.zdpp.lab03gr1.database.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import pl.escience.zdpp.lab03gr1.database.EntityCRUD;
import pl.escience.zdpp.lab03gr1.database.entity.WishTemplate;

import java.util.List;

/**
 * <p>WishTemplateDAO class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
public class WishTemplateDAO implements EntityCRUD<WishTemplate> {
    private final SessionFactory sessionFactory;

    /**
     * <p>Constructor for WishTemplateDAO.</p>
     *
     * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
     */
    public WishTemplateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * <p>getEntities.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<WishTemplate> getEntities() {
        List<WishTemplate> wishTemplates;
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Query<WishTemplate> theQuery = currentSession.createQuery("from WishTemplate", WishTemplate.class);
        wishTemplates = theQuery.getResultList();
        currentSession.getTransaction().commit();

        return wishTemplates;
    }

    /**
     * <p>saveEntity.</p>
     *
     * @param entity a {@link pl.escience.zdpp.lab03gr1.database.entity.WishTemplate} object.
     */
    public void saveEntity(WishTemplate entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(entity);
        currentSession.getTransaction().commit();
    }

    /** {@inheritDoc} */
    public WishTemplate getEntity(int id) {
        WishTemplate wishTemplate;
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        wishTemplate = currentSession.get(WishTemplate.class, id);
        currentSession.getTransaction().commit();

        return wishTemplate;
    }

    /** {@inheritDoc} */
    public void deleteEntity(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.createQuery("delete from WishTemplate where id=:wishTemplateId")
                .setParameter("wishTemplateId", id).executeUpdate();
        currentSession.getTransaction().commit();
    }
}
