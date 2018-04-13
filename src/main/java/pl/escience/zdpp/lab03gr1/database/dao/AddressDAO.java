package pl.escience.zdpp.lab03gr1.database.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import pl.escience.zdpp.lab03gr1.database.EntityCRUD;
import pl.escience.zdpp.lab03gr1.database.entity.Address;

import java.util.List;

/**
 * <p>AddressDAO class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
public class AddressDAO implements EntityCRUD<Address> {
    private final SessionFactory sessionFactory;

    /**
     * <p>Constructor for AddressDAO.</p>
     *
     * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
     */
    public AddressDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * <p>getEntities.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<Address> getEntities() {
        List<Address> addresses;
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Query<Address> theQuery = currentSession.createQuery("from Address", Address.class);
        addresses = theQuery.getResultList();
        currentSession.getTransaction().commit();

        return addresses;
    }

    /**
     * <p>saveEntity.</p>
     *
     * @param entity a {@link pl.escience.zdpp.lab03gr1.database.entity.Address} object.
     */
    public void saveEntity(Address entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(entity);
        currentSession.getTransaction().commit();
    }

    /** {@inheritDoc} */
    public Address getEntity(int id) {
        Address address;
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        address = currentSession.get(Address.class, id);
        currentSession.getTransaction().commit();

        return address;
    }

    /** {@inheritDoc} */
    public void deleteEntity(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.createQuery("delete from Address where id=:addressId")
                .setParameter("addressId", id).executeUpdate();
        currentSession.getTransaction().commit();
    }
}
