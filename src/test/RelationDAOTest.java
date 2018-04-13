import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.escience.zdpp.lab03gr1.database.entity.*;
import pl.escience.zdpp.lab03gr1.database.service.ReminderService;
import pl.escience.zdpp.lab03gr1.database.view.ViewExtendedPersonAnniversary;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class RelationDAOTest {
    private SessionFactory factory;
    private ReminderService reminderService;
    private Integer relationId = null;

    @Before
    public void before() {
        setupLog4J();
        factory = createSessionFactory();
        reminderService = new ReminderService(factory);
    }

    @Test
    public void createRelationObjectInDb() {
        Relation relationToDb = new Relation("Relacja");
        reminderService.saveRelation(relationToDb);

        Relation relationFromDb = reminderService.getRelation(relationToDb.getId());
        relationId = relationFromDb.getId();
        assertEquals("Relacja", relationFromDb.getRalationName());
    }

    @After
    public void after() {
        if (relationId != null)
            reminderService.deleteRelation(relationId);
        factory.close();
    }

    private SessionFactory createSessionFactory() {
        factory = new Configuration()
                .configure()
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(PersonAnniversary.class)
                .addAnnotatedClass(Relation.class)
                .addAnnotatedClass(SentWish.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(WishTemplate.class)
                .addAnnotatedClass(ViewExtendedPersonAnniversary.class)
                .buildSessionFactory();
        return factory;
    }

    private static void setupLog4J() {
        System.setProperty("log4j.configuration", new File(".", File.separatorChar +
                "src/main/resources/log4j_config/log4j.properties").toURI().toString());
    }
}
