package pl.escience.zdpp.lab03gr1.app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.GenericJDBCException;
import pl.escience.zdpp.lab03gr1.database.entity.*;
import pl.escience.zdpp.lab03gr1.database.service.ReminderService;
import pl.escience.zdpp.lab03gr1.database.view.ViewExtendedPersonAnniversary;
import pl.escience.zdpp.lab03gr1.javafx.controller.WelcomeBannerController;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WishesReminder extends Application {
    private SessionFactory sessionFactory;

    private static Stage mainStage;
    private static ReminderService reminderService;
    private static User loggedUser;
    private static ObservableList<Relation> relationObservableList = FXCollections.observableArrayList();

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Stage mainStage) {
        WishesReminder.mainStage = mainStage;
    }

    public static ReminderService getReminderService() {
        return reminderService;
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User loggedUser) {
        WishesReminder.loggedUser = loggedUser;
    }

    public static ObservableList<Relation> getRelationObservableList() {
        return relationObservableList;
    }

    public void start(Stage primaryStage) {
        setupLog4J();
        initSessionFactory();
        reminderService = new ReminderService(sessionFactory);

        FXMLLoader loader = new FXMLLoader();
        try {
            WishesReminder.mainStage = primaryStage;
            loader.setLocation(getClass().getClassLoader().getResource("fxml/welcome_banner.fxml"));
            loader.load();
            Parent root = loader.getRoot();
            mainStage.setTitle("Wishes Reminder");
            mainStage.getIcons().add(new Image("/image/icon.png"));
            mainStage.initStyle(StageStyle.UNDECORATED);
            mainStage.resizableProperty().setValue(Boolean.FALSE);
            mainStage.setScene(new Scene(root, 819, 325));
            WelcomeBannerController loaderController = loader.getController();
            mainStage.addEventHandler(WindowEvent.WINDOW_SHOWN, window -> {
                Thread windowShownListener = new Thread(loaderController::initMainScene);
                windowShownListener.start();
            });
            relationObservableList.addAll(reminderService.getRalations());
            mainStage.centerOnScreen();
            mainStage.show();
        } catch (IOException ioEcx) {
            Logger.getLogger(WishesReminder.class.getName()).log(Level.SEVERE, null, ioEcx);
        }
    }

    public void stop() {
        sessionFactory.close();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static void setupLog4J() {
        System.setProperty("log4j.configuration", new File(".", File.separatorChar +
                "src/main/resources/log4j_config/log4j.properties").toURI().toString());
    }

    private void initSessionFactory() {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(PersonAnniversary.class)
                    .addAnnotatedClass(Relation.class)
                    .addAnnotatedClass(SentWish.class)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(WishTemplate.class)
                    .addAnnotatedClass(ViewExtendedPersonAnniversary.class)
                    .buildSessionFactory();
        } catch (GenericJDBCException e) {
            System.out.println("Błąd połączenia z bazą danych.\nPowód: " + e.getCause().getMessage());
            System.exit(0);
        }
    }
}
