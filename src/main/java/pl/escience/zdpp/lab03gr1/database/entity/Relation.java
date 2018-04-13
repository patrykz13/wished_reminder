package pl.escience.zdpp.lab03gr1.database.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
/**
 * <p>Relation class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
@Table(name = "relation")
public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "relation_name")
    private String ralationName;

    @OneToMany(mappedBy = "relation", cascade = CascadeType.ALL)
    private List<PersonAnniversary> personAnniversaries;

    /**
     * <p>Constructor for Relation.</p>
     */
    public Relation() {
    }

    /**
     * <p>Constructor for Relation.</p>
     *
     * @param ralationName a {@link java.lang.String} object.
     */
    public Relation(String ralationName) {
        this.ralationName = ralationName;
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
     * <p>Getter for the field <code>ralationName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRalationName() {
        return ralationName;
    }

    /**
     * <p>Setter for the field <code>ralationName</code>.</p>
     *
     * @param ralationName a {@link java.lang.String} object.
     */
    public void setRalationName(String ralationName) {
        this.ralationName = ralationName;
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
     * <p>addPersonAnniverasry.</p>
     *
     * @param personAnniversary a {@link pl.escience.zdpp.lab03gr1.database.entity.PersonAnniversary} object.
     */
    public void addPersonAnniverasry(PersonAnniversary personAnniversary) {
        if (personAnniversaries == null)
            personAnniversaries = new ArrayList<>();

        personAnniversaries.add(personAnniversary);
        personAnniversary.setRelation(this);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return ralationName;
    }
}
