package pl.escience.zdpp.lab03gr1.javafx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pl.escience.zdpp.lab03gr1.app.WishesReminder;
import pl.escience.zdpp.lab03gr1.database.entity.User;
import pl.escience.zdpp.lab03gr1.database.entity.WishTemplate;
import pl.escience.zdpp.lab03gr1.database.exception.UniqueViolationException;
import pl.escience.zdpp.lab03gr1.database.service.ReminderService;
import pl.escience.zdpp.lab03gr1.javafx.CustomMessageBox;
import pl.escience.zdpp.lab03gr1.xml_parser.Parser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WishTemplatesController implements Initializable {
    private CustomMessageBox customMessageBox;
    private User loggedUser;
    private ReminderService reminderService;
    private ObservableList<WishTemplate> wishTemplateObservableList = FXCollections.observableArrayList();

    @FXML
    private Label labelNumberOfWishTemplates;
    @FXML
    private TableView<WishTemplate> tableViewWishTemplates;
    @FXML
    private TableColumn<WishTemplate, String> tableColumnWishTemplatesText;
    @FXML
    private TextArea textAreaSelectedWishTemplateText, textAreaNewWishText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loggedUser = WishesReminder.getLoggedUser();
        reminderService = WishesReminder.getReminderService();
        customMessageBox = new CustomMessageBox("image/icon.png");
        textAreaNewWishText.setText("");
        textAreaSelectedWishTemplateText.setText("");
        initTableView();
        wishTemplateObservableList.addAll(loggedUser.getWishTemplates());
        tableViewWishTemplates.setItems(wishTemplateObservableList);
        setLabelNumberOfWishTemplates();
    }

    @FXML
    void buttonAdd_onAction() throws UniqueViolationException {
        if (!textAreaNewWishText.getText().equals("")) {
            WishTemplate wishTemplate = new WishTemplate(textAreaNewWishText.getText());
            loggedUser.addWishTemplate(wishTemplate);
            reminderService.saveUser(loggedUser);
            wishTemplateObservableList.add(wishTemplate);
            textAreaNewWishText.clear();
            setLabelNumberOfWishTemplates();
        } else {
            customMessageBox.showMessageBox(Alert.AlertType.WARNING, "Ostrzeżenie",
                    "Operacja dodania szablonu życzeń nie powiodłą się.",
                    "Powód: nie uzupełniono treści życzenia.").showAndWait();
        }
    }

    @FXML
    void buttonBack_onAction() {
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
            primaryStage.setScene(new Scene(parent, 1599, 900));
            Stage stage = (Stage) textAreaNewWishText.getScene().getWindow();
            stage.hide();
            primaryStage.show();
        } catch (IOException ioEcx) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ioEcx);
        }
    }

    @FXML
    void buttonDelete_onAction() {
        WishTemplate selectedWishTemplate = tableViewWishTemplates.getSelectionModel().getSelectedItem();
        if (selectedWishTemplate != null) {
            reminderService.deleteWishTemplate(selectedWishTemplate.getId());
            loggedUser.getWishTemplates().remove(selectedWishTemplate);
            wishTemplateObservableList.remove(selectedWishTemplate);
            textAreaNewWishText.clear();
            setLabelNumberOfWishTemplates();
        } else {
            customMessageBox.showMessageBox(Alert.AlertType.WARNING, "Ostrzeżenie",
                    "Operacja usuwania szablonu życzeń nie powiodłą się.",
                    "Powód: nie zaznaczono szablonu życzeń.").showAndWait();
        }
    }

    @FXML
    void buttonReadFromFile_onAction() {
        String xmlPath;
        FileChooser frontCoversFileChooser = new FileChooser();
        frontCoversFileChooser.setTitle("Wybór tekstu szablonu życzeń z pliku");
        frontCoversFileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Szablony życzeń", "*.xml"));
        File file = frontCoversFileChooser.showOpenDialog(WishesReminder.getMainStage());
        if (file != null) {
            try {
                xmlPath = file.toString();
                Parser parser = new Parser();
                WishTemplate wishTemplate;
                wishTemplate = parser.readFromXMLFile(xmlPath);
                textAreaNewWishText.setText(wishTemplate.getText());
            } catch (JAXBException e) {
                customMessageBox.showMessageBox(Alert.AlertType.WARNING, "Ostrzeżenie",
                        "Błąd odczytu szablonu życzenia z pliku.",
                        "Powód: " + e.getMessage() + ".").showAndWait();
            }
        }
    }

    @FXML
    void buttonWriteToFile_onAction() {
        if (tableViewWishTemplates.getSelectionModel().getSelectedItem() != null) {
            DirectoryChooser chooser = new DirectoryChooser();
            chooser.setTitle("Wybór lokalizacji zapisu szablonu życzeń");
            File directory = chooser.showDialog(WishesReminder.getMainStage());
            if (directory != null) {
                try {
                    Parser parser = new Parser();
                    WishTemplate wishTemplate = tableViewWishTemplates.getSelectionModel().getSelectedItem();
                    parser.saveToXMLFile(wishTemplate, directory.toString());
                } catch (JAXBException e) {
                    customMessageBox.showMessageBox(Alert.AlertType.WARNING, "Ostrzeżenie",
                            "Błąd zapisu szablonu życzenia do pliku.",
                            "Powód: " + e.getMessage() + ".").showAndWait();
                }
            }
        } else {
            customMessageBox.showMessageBox(Alert.AlertType.WARNING, "Ostrzeżenie",
                    "Operacja zapisu do pliku nie powiodła się.",
                    "Powód: nie zaznaczono szablonu życzeń.").showAndWait();
        }
    }

    @FXML
    void tableViewWishTemplates_onMouseClicked() {
        if (tableViewWishTemplates.getSelectionModel().getSelectedItem() != null) {
            textAreaSelectedWishTemplateText.setText(tableViewWishTemplates.getSelectionModel().getSelectedItem().getText());
        }
    }

    private void initTableView() {
        tableColumnWishTemplatesText.setCellValueFactory(new PropertyValueFactory<>("text"));
    }

    private void setLabelNumberOfWishTemplates() {
        labelNumberOfWishTemplates.setText(String.valueOf(tableViewWishTemplates.getItems().size()));
    }
}
