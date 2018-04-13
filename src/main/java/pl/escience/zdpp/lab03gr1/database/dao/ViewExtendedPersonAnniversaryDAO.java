package pl.escience.zdpp.lab03gr1.database.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import pl.escience.zdpp.lab03gr1.database.view.ViewExtendedPersonAnniversary;

import java.util.List;

public class ViewExtendedPersonAnniversaryDAO {
    private SessionFactory sessionFactory;

    public ViewExtendedPersonAnniversaryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<ViewExtendedPersonAnniversary> getEntities() {
        List<ViewExtendedPersonAnniversary> contacts;
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            currentSession.beginTransaction();
            Query<ViewExtendedPersonAnniversary> theQuery = currentSession.createQuery("from ViewExtendedPersonAnniversary",
                    ViewExtendedPersonAnniversary.class);
            contacts = theQuery.getResultList();
            currentSession.getTransaction().commit();
        }
        return contacts;
    }

    public List<ViewExtendedPersonAnniversary> getEntitiesByUserId(int id) {
        List<ViewExtendedPersonAnniversary> infoAboutDiscounts = null;
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            currentSession.beginTransaction();
            Query<ViewExtendedPersonAnniversary> theQuery = currentSession
                    .createQuery("from ViewExtendedPersonAnniversary where userId =:userId",
                            ViewExtendedPersonAnniversary.class)
                    .setParameter("userId", id);
            infoAboutDiscounts = theQuery.getResultList();
            currentSession.getTransaction().commit();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return infoAboutDiscounts;
    }

    public ViewExtendedPersonAnniversary getEntity(int id) {
        ViewExtendedPersonAnniversary viewExtendedContact;
        try (Session currentSession = sessionFactory.getCurrentSession()) {
            currentSession.beginTransaction();
            viewExtendedContact = currentSession.get(ViewExtendedPersonAnniversary.class, id);
            currentSession.getTransaction().commit();
        }
        return viewExtendedContact;
    }
}
