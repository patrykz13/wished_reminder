package pl.escience.zdpp.lab03gr1.javafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import pl.escience.zdpp.lab03gr1.app.WishesReminder;
import pl.escience.zdpp.lab03gr1.database.entity.User;
import pl.escience.zdpp.lab03gr1.database.service.ReminderService;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>LoginController class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
public class LoginController implements Initializable {
    private ReminderService reminderService;

    @FXML
    private TextField textFieldLogin;
    @FXML
    private PasswordField passwordFieldPassword;
    @FXML
    private Label labelInvalidLoginOrPassword;

    /** {@inheritDoc} */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reminderService = WishesReminder.getReminderService();
    }

    @FXML
    void buttonLogin_onAction() {
        if (textFieldLogin.getText().equals("") || passwordFieldPassword.getText().equals(""))
            labelInvalidLoginOrPassword.setText("Nie podano danych logowania.");
        else {
            try {
                User loggedUser = reminderService.getUserByLogin(textFieldLogin.getText());
                if (loggedUser != null && loggedUser.getPassword().equals(passwordFieldPassword.getText())) {
                    WishesReminder.setLoggedUser(loggedUser);
                    FXMLLoader loader = new FXMLLoader();
                    try {
                        loader.setLocation(getClass().getClassLoader().getResource("fxml/main.fxml"));
                        loader.load();
                        Parent parent = loader.getRoot();
                        Stage primaryStage = new Stage();
                        WishesReminder.setMainStage(primaryStage);
                        primaryStage.setTitle("Wishes Reminder");
                        primaryStage.getIcons().add(new Image("/image/icon.png"));
                        primaryStage.setMinWidth(950);
                        primaryStage.setMinHeight(890);
                        primaryStage.setScene(new Scene(parent, 1600, 900));
                        Stage stage = (Stage) textFieldLogin.getScene().getWindow();
                        stage.hide();
                        primaryStage.show();
                    } catch (IOException ioEcx) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ioEcx);
                    }
                } else
                    labelInvalidLoginOrPassword.setText("Niepoprawne hasło.");
            } catch (NoResultException e) {
                labelInvalidLoginOrPassword.setText("Użytkownik nie istnieje.");
            }
        }
    }

    @FXML
    void buttonRegister_onAction() {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getClassLoader().getResource("fxml/register_or_modify_account.fxml"));
            loader.load();
            Parent parent = loader.getRoot();
            Stage primaryStage = new Stage();
            WishesReminder.setMainStage(primaryStage);
            primaryStage.setTitle("Wishes Reminder");
            primaryStage.getIcons().add(new Image("/image/icon.png"));
            primaryStage.setMinWidth(1100);
            primaryStage.setMinHeight(765);
            primaryStage.setScene(new Scene(parent, 1200, 780));
            Stage stage = (Stage) textFieldLogin.getScene().getWindow();
            stage.hide();
            primaryStage.show();
        } catch (IOException ioEcx) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ioEcx);
        }
    }

    @FXML
    void passwordFieldPassword_onKeyPressed() {
        if (!labelInvalidLoginOrPassword.getText().equals(""))
            labelInvalidLoginOrPassword.setText("");
    }

    @FXML
    void textFieldLogin_onKeyPressed() {
        if (!labelInvalidLoginOrPassword.getText().equals(""))
            labelInvalidLoginOrPassword.setText("");
    }
}
