package pl.escience.zdpp.lab03gr1.database.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
/**
 * <p>SentWish class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
@Table(name = "sent_wish")
public class SentWish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "post_date")
    private Date postDate;

    @Column(name = "sent_by_letter")
    private Boolean sentByLetter;

    @Column(name = "sent_by_email")
    private Boolean sentByEmail;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "person_anniversary_id")
    private PersonAnniversary personAnniversary;

    /**
     * <p>Constructor for SentWish.</p>
     */
    public SentWish() {
    }

    /**
     * <p>Constructor for SentWish.</p>
     *
     * @param text a {@link java.lang.String} object.
     * @param postDate a {@link java.util.Date} object.
     * @param sentByLetter a {@link java.lang.Boolean} object.
     * @param sentByEmail a {@link java.lang.Boolean} object.
     */
    public SentWish(String text, Date postDate, Boolean sentByLetter, Boolean sentByEmail) {
        this.text = text;
        this.postDate = postDate;
        this.sentByLetter = sentByLetter;
        this.sentByEmail = sentByEmail;
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
     * <p>Getter for the field <code>text</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getText() {
        return text;
    }

    /**
     * <p>Setter for the field <code>text</code>.</p>
     *
     * @param text a {@link java.lang.String} object.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * <p>Getter for the field <code>postDate</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getPostDate() {
        return postDate;
    }

    /**
     * <p>Setter for the field <code>postDate</code>.</p>
     *
     * @param postDate a {@link java.util.Date} object.
     */
    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    /**
     * <p>Getter for the field <code>sentByLetter</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getSentByLetter() {
        return sentByLetter;
    }

    /**
     * <p>Setter for the field <code>sentByLetter</code>.</p>
     *
     * @param sentByLetter a {@link java.lang.Boolean} object.
     */
    public void setSentByLetter(Boolean sentByLetter) {
        this.sentByLetter = sentByLetter;
    }

    /**
     * <p>Getter for the field <code>sentByEmail</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getSentByEmail() {
        return sentByEmail;
    }

    /**
     * <p>Setter for the field <code>sentByEmail</code>.</p>
     *
     * @param sentByEmail a {@link java.lang.Boolean} object.
     */
    public void setSentByEmail(Boolean sentByEmail) {
        this.sentByEmail = sentByEmail;
    }

    /**
     * <p>Getter for the field <code>personAnniversary</code>.</p>
     *
     * @return a {@link pl.escience.zdpp.lab03gr1.database.entity.PersonAnniversary} object.
     */
    public PersonAnniversary getPersonAnniversary() {
        return personAnniversary;
    }

    /**
     * <p>Setter for the field <code>personAnniversary</code>.</p>
     *
     * @param personAnniversary a {@link pl.escience.zdpp.lab03gr1.database.entity.PersonAnniversary} object.
     */
    public void setPersonAnniversary(PersonAnniversary personAnniversary) {
        this.personAnniversary = personAnniversary;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "SentWish{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", postDate=" + postDate +
                ", sentByLetter=" + sentByLetter +
                ", sentByEmail=" + sentByEmail +
                '}';
    }
}
