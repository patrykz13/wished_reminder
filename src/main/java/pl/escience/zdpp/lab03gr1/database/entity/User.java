package pl.escience.zdpp.lab03gr1.database.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
/**
 * <p>User class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private List<WishTemplate> wishTemplates;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PersonAnniversary> personAnniversaries;

    /**
     * <p>Constructor for User.</p>
     */
    public User() {
    }

    /**
     * <p>Constructor for User.</p>
     *
     * @param login a {@link java.lang.String} object.
     * @param password a {@link java.lang.String} object.
     * @param firstName a {@link java.lang.String} object.
     * @param lastName a {@link java.lang.String} object.
     * @param email a {@link java.lang.String} object.
     */
    public User(String login, String password, String firstName, String lastName, String email) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getId() {
        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <p>Getter for the field <code>login</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLogin() {
        return login;
    }

    /**
     * <p>Setter for the field <code>login</code>.</p>
     *
     * @param login a {@link java.lang.String} object.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * <p>Getter for the field <code>password</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>Setter for the field <code>password</code>.</p>
     *
     * @param password a {@link java.lang.String} object.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <p>Getter for the field <code>firstName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * <p>Setter for the field <code>firstName</code>.</p>
     *
     * @param firstName a {@link java.lang.String} object.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * <p>Getter for the field <code>lastName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * <p>Setter for the field <code>lastName</code>.</p>
     *
     * @param lastName a {@link java.lang.String} object.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * <p>Getter for the field <code>email</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>Setter for the field <code>email</code>.</p>
     *
     * @param email a {@link java.lang.String} object.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <p>Getter for the field <code>address</code>.</p>
     *
     * @return a {@link pl.escience.zdpp.lab03gr1.database.entity.Address} object.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * <p>Setter for the field <code>address</code>.</p>
     *
     * @param address a {@link pl.escience.zdpp.lab03gr1.database.entity.Address} object.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * <p>Getter for the field <code>wishTemplates</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<WishTemplate> getWishTemplates() {
        return wishTemplates;
    }

    /**
     * <p>Setter for the field <code>wishTemplates</code>.</p>
     *
     * @param wishTemplates a {@link java.util.List} object.
     */
    public void setWishTemplates(List<WishTemplate> wishTemplates) {
        this.wishTemplates = wishTemplates;
    }

    /**
     * <p>Getter for the field <code>personAnniversaries</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<PersonAnniversary> getPersonAnniversaries() {
        return personAnniversaries;
    }

    /**
     * <p>Setter for the field <code>personAnniversaries</code>.</p>
     *
     * @param personAnniversaries a {@link java.util.List} object.
     */
    public void setPersonAnniversaries(List<PersonAnniversary> personAnniversaries) {
        this.personAnniversaries = personAnniversaries;
    }

    /**
     * <p>addWishTemplate.</p>
     *
     * @param wishTemplate a {@link pl.escience.zdpp.lab03gr1.database.entity.WishTemplate} object.
     */
    public void addWishTemplate(WishTemplate wishTemplate) {
        if (wishTemplates == null)
            wishTemplates = new ArrayList<>();

        wishTemplates.add(wishTemplate);
        wishTemplate.setUser(this);
    }

    /**
     * <p>addPersonAnniversary.</p>
     *
     * @param personAnniversary a {@link pl.escience.zdpp.lab03gr1.database.entity.PersonAnniversary} object.
     */
    public void addPersonAnniversary(PersonAnniversary personAnniversary) {
        if (personAnniversaries == null)
            personAnniversaries = new ArrayList<>();

        personAnniversaries.add(personAnniversary);
        personAnniversary.setUser(this);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}