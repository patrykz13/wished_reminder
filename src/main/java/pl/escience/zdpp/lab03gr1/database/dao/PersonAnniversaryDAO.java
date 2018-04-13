package pl.escience.zdpp.lab03gr1.database.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import pl.escience.zdpp.lab03gr1.database.EntityCRUD;
import pl.escience.zdpp.lab03gr1.database.entity.PersonAnniversary;

import java.util.List;

/**
 * <p>PersonAnniversaryDAO class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
public class PersonAnniversaryDAO implements EntityCRUD<PersonAnniversary> {
    private final SessionFactory sessionFactory;

    /**
     * <p>Constructor for PersonAnniversaryDAO.</p>
     *
     * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
     */
    public PersonAnniversaryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * <p>getEntities.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<PersonAnniversary> getEntities() {
        List<PersonAnniversary> personAnniversaries;
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Query<PersonAnniversary> theQuery = currentSession.createQuery("from PersonAnniversary", PersonAnniversary.class);
        personAnniversaries = theQuery.getResultList();
        currentSession.getTransaction().commit();

        return personAnniversaries;
    }

    /**
     * <p>saveEntity.</p>
     *
     * @param entity a {@link pl.escience.zdpp.lab03gr1.database.entity.PersonAnniversary} object.
     */
    public void saveEntity(PersonAnniversary entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(entity);
        currentSession.getTransaction().commit();
    }

    /** {@inheritDoc} */
    public PersonAnniversary getEntity(int id) {
        PersonAnniversary personAnniversary;
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        personAnniversary = currentSession.get(PersonAnniversary.class, id);
        currentSession.getTransaction().commit();

        return personAnniversary;
    }

    /** {@inheritDoc} */
    public void deleteEntity(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.createQuery("delete from PersonAnniversary where id=:personAnniversaryId")
                .setParameter("personAnniversaryId", id).executeUpdate();
        currentSession.getTransaction().commit();
    }
}
