package pl.escience.zdpp.lab03gr1.database.service;

import org.hibernate.SessionFactory;
import pl.escience.zdpp.lab03gr1.database.dao.*;
import pl.escience.zdpp.lab03gr1.database.entity.*;
import pl.escience.zdpp.lab03gr1.database.exception.UniqueViolationException;
import pl.escience.zdpp.lab03gr1.database.view.ViewExtendedPersonAnniversary;

import java.util.List;

/**
 * <p>ReminderService class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
public class ReminderService {
    private AddressDAO addressDAO;
    private PersonAnniversaryDAO personAnniversaryDAO;
    private RelationDAO relationDAO;
    private SentWishDAO sentWishDAO;
    private UserDAO userDAO;
    private WishTemplateDAO wishTemplateDAO;
    private ViewExtendedPersonAnniversaryDAO viewExtendedPersonAnniversaryDAO;

    /**
     * <p>Constructor for ReminderService.</p>
     *
     * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
     */
    public ReminderService(SessionFactory sessionFactory) {
        addressDAO = new AddressDAO(sessionFactory);
        personAnniversaryDAO = new PersonAnniversaryDAO(sessionFactory);
        relationDAO = new RelationDAO(sessionFactory);
        sentWishDAO = new SentWishDAO(sessionFactory);
        userDAO = new UserDAO(sessionFactory);
        wishTemplateDAO = new WishTemplateDAO(sessionFactory);
        viewExtendedPersonAnniversaryDAO = new ViewExtendedPersonAnniversaryDAO(sessionFactory);
    }

    /**
     * <p>getAddresses.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<Address> getAddresses() {
        return addressDAO.getEntities();
    }

    /**
     * <p>saveAddress.</p>
     *
     * @param address a {@link pl.escience.zdpp.lab03gr1.database.entity.Address} object.
     */
    public void saveAddress(Address address) {
        addressDAO.saveEntity(address);
    }

    /**
     * <p>getAddress.</p>
     *
     * @param id a int.
     * @return a {@link pl.escience.zdpp.lab03gr1.database.entity.Address} object.
     */
    public Address getAddress(int id) {
        return addressDAO.getEntity(id);
    }

    /**
     * <p>deleteAddress.</p>
     *
     * @param id a int.
     */
    public void deleteAddress(int id) {
        addressDAO.deleteEntity(id);
    }

    /**
     * <p>getUsers.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<User> getUsers() {
        return userDAO.getEntities();
    }

    /**
     * <p>saveUser.</p>
     *
     * @param user a {@link pl.escience.zdpp.lab03gr1.database.entity.User} object.
     * @throws pl.escience.zdpp.lab03gr1.database.exception.UniqueViolationException if any.
     */
    public void saveUser(User user) throws UniqueViolationException {
        userDAO.saveEntity(user);
    }

    /**
     * <p>getUser.</p>
     *
     * @param id a int.
     * @return a {@link pl.escience.zdpp.lab03gr1.database.entity.User} object.
     */
    public User getUser(int id) {
        return userDAO.getEntity(id);
    }

    /**
     * <p>getUserByLogin.</p>
     *
     * @param login a {@link java.lang.String} object.
     * @return a {@link pl.escience.zdpp.lab03gr1.database.entity.User} object.
     */
    public User getUserByLogin(String login) {
        return userDAO.getEntityByLogin(login);
    }

    /**
     * <p>deleteUser.</p>
     *
     * @param id a int.
     */
    public void deleteUser(int id) {
        userDAO.deleteEntity(id);
    }

    /**
     * <p>getSentWishes.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<SentWish> getSentWishes() {
        return sentWishDAO.getEntities();
    }

    /**
     * <p>saveSentWish.</p>
     *
     * @param sentWish a {@link pl.escience.zdpp.lab03gr1.database.entity.SentWish} object.
     */
    public void saveSentWish(SentWish sentWish) {
        sentWishDAO.saveEntity(sentWish);
    }

    /**
     * <p>getSentWish.</p>
     *
     * @param id a int.
     * @return a {@link pl.escience.zdpp.lab03gr1.database.entity.SentWish} object.
     */
    public SentWish getSentWish(int id) {
        return sentWishDAO.getEntity(id);
    }

    /**
     * <p>deleteSentWish.</p>
     *
     * @param id a int.
     */
    public void deleteSentWish(int id) {
        sentWishDAO.deleteEntity(id);
    }

    /**
     * <p>getRalations.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<Relation> getRalations() {
        return relationDAO.getEntities();
    }

    /**
     * <p>saveRelation.</p>
     *
     * @param relation a {@link pl.escience.zdpp.lab03gr1.database.entity.Relation} object.
     */
    public void saveRelation(Relation relation) {
        relationDAO.saveEntity(relation);
    }

    /**
     * <p>getRelation.</p>
     *
     * @param id a int.
     * @return a {@link pl.escience.zdpp.lab03gr1.database.entity.Relation} object.
     */
    public Relation getRelation(int id) {
        return relationDAO.getEntity(id);
    }

    /**
     * <p>deleteRelation.</p>
     *
     * @param id a int.
     */
    public void deleteRelation(int id) {
        relationDAO.deleteEntity(id);
    }

    /**
     * <p>getWishesTemplates.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<WishTemplate> getWishesTemplates() {
        return wishTemplateDAO.getEntities();
    }

    /**
     * <p>saveWishTemplate.</p>
     *
     * @param wishTemplate a {@link pl.escience.zdpp.lab03gr1.database.entity.WishTemplate} object.
     */
    public void saveWishTemplate(WishTemplate wishTemplate) {
        wishTemplateDAO.saveEntity(wishTemplate);
    }

    /**
     * <p>getWishTemplate.</p>
     *
     * @param id a int.
     * @return a {@link pl.escience.zdpp.lab03gr1.database.entity.WishTemplate} object.
     */
    public WishTemplate getWishTemplate(int id) {
        return wishTemplateDAO.getEntity(id);
    }

    /**
     * <p>deleteWishTemplate.</p>
     *
     * @param id a int.
     */
    public void deleteWishTemplate(int id) {
        wishTemplateDAO.deleteEntity(id);
    }

    /**
     * <p>getPersonAnniversaries.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<PersonAnniversary> getPersonAnniversaries() {
        return personAnniversaryDAO.getEntities();
    }

    /**
     * <p>savePersonAnniversary.</p>
     *
     * @param personAnniversary a {@link pl.escience.zdpp.lab03gr1.database.entity.PersonAnniversary} object.
     */
    public void savePersonAnniversary(PersonAnniversary personAnniversary) {
        personAnniversaryDAO.saveEntity(personAnniversary);
    }

    /**
     * <p>getPersonAnniversary.</p>
     *
     * @param id a int.
     * @return a {@link pl.escience.zdpp.lab03gr1.database.entity.PersonAnniversary} object.
     */
    public PersonAnniversary getPersonAnniversary(int id) {
        return personAnniversaryDAO.getEntity(id);
    }

    /**
     * <p>deletePersonAnniversary.</p>
     *
     * @param id a int.
     */
    public void deletePersonAnniversary(int id) {
        personAnniversaryDAO.deleteEntity(id);
    }

    /**
     * <p>getViewExtendedContacts.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<ViewExtendedPersonAnniversary> getViewExtendedContacts() {
        return viewExtendedPersonAnniversaryDAO.getEntities();
    }

    /**
     * <p>getViewExtendedContactsByUserId.</p>
     *
     * @param userId a int.
     * @return a {@link java.util.List} object.
     */
    public List<ViewExtendedPersonAnniversary> getViewExtendedContactsByUserId(int userId) {
        return viewExtendedPersonAnniversaryDAO.getEntitiesByUserId(userId);
    }

    /**
     * <p>getViewExtendedContact.</p>
     *
     * @param id a int.
     * @return a {@link pl.escience.zdpp.lab03gr1.database.view.ViewExtendedPersonAnniversary} object.
     */
    public ViewExtendedPersonAnniversary getViewExtendedContact(int id) {
        return viewExtendedPersonAnniversaryDAO.getEntity(id);
    }
}
