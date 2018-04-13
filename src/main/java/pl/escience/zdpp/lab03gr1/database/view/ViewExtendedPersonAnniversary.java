package pl.escience.zdpp.lab03gr1.database.view;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
/**
 * <p>ViewExtendedPersonAnniversary class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
@Immutable
@Table(name = "view_extended_person_anniversary")
public class ViewExtendedPersonAnniversary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer personAnniversaryId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "displayed_anniversary_date")
    private Date displayedAnniversaryDate;

    @Column(name = "anniversary_date")
    private Date anniversaryDate;

    @Column(name = "anniversary_kind")
    private String anniversaryKind;

    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "relation_id")
    private Integer relationId;

    @Column(name = "relation_name")
    private String relationName;

    @Column(name = "number_of_sent_wishes")
    private Integer numberOfSentWishes;

    @Transient
    private Integer numberOfDaysToNextAnniversary;

    @Transient
    private Date nextAnniversaryDate;

    /**
     * <p>Constructor for ViewExtendedPersonAnniversary.</p>
     */
    public ViewExtendedPersonAnniversary() {
    }

    /**
     * <p>Constructor for ViewExtendedPersonAnniversary.</p>
     *
     * @param userId a {@link java.lang.Integer} object.
     * @param firstName a {@link java.lang.String} object.
     * @param lastName a {@link java.lang.String} object.
     * @param email a {@link java.lang.String} object.
     * @param displayedAnniversaryDate a {@link java.util.Date} object.
     * @param anniversaryDate a {@link java.util.Date} object.
     * @param anniversaryKind a {@link java.lang.String} object.
     * @param addressId a {@link java.lang.Integer} object.
     * @param street a {@link java.lang.String} object.
     * @param city a {@link java.lang.String} object.
     * @param postalCode a {@link java.lang.String} object.
     * @param country a {@link java.lang.String} object.
     * @param relationId a {@link java.lang.Integer} object.
     * @param relationName a {@link java.lang.String} object.
     * @param numberOfSentWishes a {@link java.lang.Integer} object.
     */
    public ViewExtendedPersonAnniversary(Integer userId, String firstName, String lastName, String email,
                                         Date displayedAnniversaryDate, Date anniversaryDate, String anniversaryKind,
                                         Integer addressId, String street, String city, String postalCode,
                                         String country, Integer relationId, String relationName,
                                         Integer numberOfSentWishes) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.displayedAnniversaryDate = displayedAnniversaryDate;
        this.anniversaryDate = anniversaryDate;
        this.anniversaryKind = anniversaryKind;
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.relationId = relationId;
        this.relationName = relationName;
        this.numberOfSentWishes = numberOfSentWishes;
    }

    /**
     * <p>Getter for the field <code>personAnniversaryId</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPersonAnniversaryId() {
        return personAnniversaryId;
    }

    /**
     * <p>Getter for the field <code>userId</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getUserId() {
        return userId;
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
     * <p>Getter for the field <code>lastName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLastName() {
        return lastName;
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
     * <p>Getter for the field <code>displayedAnniversaryDate</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getDisplayedAnniversaryDate() {
        return displayedAnniversaryDate;
    }

    /**
     * <p>Setter for the field <code>anniversaryDate</code>.</p>
     *
     * @param anniversaryDate a {@link java.util.Date} object.
     */
    public void setAnniversaryDate(Date anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
    }

    /**
     * <p>Getter for the field <code>anniversaryDate</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getAnniversaryDate() {
        return anniversaryDate;
    }

    /**
     * <p>Getter for the field <code>anniversaryKind</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAnniversaryKind() {
        return anniversaryKind;
    }

    /**
     * <p>Getter for the field <code>addressId</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * <p>Getter for the field <code>street</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getStreet() {
        return street;
    }

    /**
     * <p>Getter for the field <code>city</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCity() {
        return city;
    }

    /**
     * <p>Getter for the field <code>postalCode</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * <p>Getter for the field <code>country</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCountry() {
        return country;
    }

    /**
     * <p>Getter for the field <code>relationId</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getRelationId() {
        return relationId;
    }

    /**
     * <p>Getter for the field <code>relationName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRelationName() {
        return relationName;
    }

    /**
     * <p>Getter for the field <code>numberOfSentWishes</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getNumberOfSentWishes() {
        return numberOfSentWishes;
    }

    /**
     * <p>Getter for the field <code>numberOfDaysToNextAnniversary</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getNumberOfDaysToNextAnniversary() {
        return numberOfDaysToNextAnniversary;
    }

    /**
     * <p>Getter for the field <code>nextAnniversaryDate</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getNextAnniversaryDate() {
        return nextAnniversaryDate;
    }

    public Integer incrementNumberOfSentWishes(){
        if (numberOfSentWishes==null)
            numberOfSentWishes = 1;
        else numberOfSentWishes++;
        return numberOfSentWishes;
    }

    /**
     * <p>calculateNextAnniversaryFields.</p>
     *
     * @param systemTime a {@link java.util.Calendar} object.
     */
    public void calculateNextAnniversaryFields(Calendar systemTime) {
        Calendar anniversaryDate = Calendar.getInstance();
        anniversaryDate.setTime(this.anniversaryDate);

        int anniversaryDateMonth = anniversaryDate.get(Calendar.MONTH) + 1;
        int anniversaryDateDay = anniversaryDate.get(Calendar.DAY_OF_MONTH);

        int dateNowYear = systemTime.get(Calendar.YEAR);
        int dateNowMonth = systemTime.get(Calendar.MONTH) + 1;
        int dateNowDay = systemTime.get(Calendar.DAY_OF_MONTH);

        Calendar nextAnniversaryDate = Calendar.getInstance();
        nextAnniversaryDate.set(Calendar.DAY_OF_MONTH, anniversaryDateDay);
        nextAnniversaryDate.set(Calendar.MONTH, anniversaryDateMonth - 1);

        if ((dateNowMonth == anniversaryDateMonth && dateNowDay <= anniversaryDateDay)
                || (dateNowMonth < anniversaryDateMonth))
            nextAnniversaryDate.set(Calendar.YEAR, dateNowYear);
        else
            nextAnniversaryDate.set(Calendar.YEAR, dateNowYear + 1);
        this.nextAnniversaryDate = nextAnniversaryDate.getTime();

        long numberOfDaysToNextAnniversary = nextAnniversaryDate.getTime().getTime() - systemTime.getTime().getTime();
        this.numberOfDaysToNextAnniversary = Math.toIntExact(numberOfDaysToNextAnniversary / 1000 / 60 / 60 / 24);
    }


    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "ViewExtendedPersonAnniversary{" +
                "personAnniversaryId=" + personAnniversaryId +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", displayedAnniversaryDate=" + displayedAnniversaryDate +
                ", anniversaryDate=" + anniversaryDate +
                ", anniversaryKind='" + anniversaryKind + '\'' +
                ", addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", relationId=" + relationId +
                ", relationName='" + relationName + '\'' +
                ", numberOfSentWishes=" + numberOfSentWishes +
                ", numberOfDaysToNextAnniversary=" + numberOfDaysToNextAnniversary +
                ", nextAnniversaryDate=" + nextAnniversaryDate +
                '}';
    }
}