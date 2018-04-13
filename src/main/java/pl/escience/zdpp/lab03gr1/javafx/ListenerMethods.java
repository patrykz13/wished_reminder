package pl.escience.zdpp.lab03gr1.javafx;

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * <p>ListenerMethods class.</p>
 *
 * @author Patryk Zdral
 * @version $Id: $Id
 */
public class ListenerMethods {
    /**
     * <p>Constructor for ListenerMethods.</p>
     */
    public ListenerMethods() {

    }

    /**
     * <p>changeLabelTextField.</p>
     *
     * @param regex a {@link java.lang.String} object.
     * @param textField a javafx.scene.control.TextField object.
     * @param label a javafx.scene.control.Label object.
     * @param isEmpty a {@link java.lang.String} object.
     * @param doesNotFit a {@link java.lang.String} object.
     * @param length a {@link java.lang.Integer} object.
     * @param tooLong a {@link java.lang.String} object.
     */
    public void changeLabelTextField(String regex, TextField textField, Label label, String isEmpty, String doesNotFit,
                                     Integer length, String tooLong) {
        if (textField.getText().isEmpty())
            label.setText(isEmpty);
        else if (!textField.getText().matches(regex))
            label.setText(doesNotFit);
        else if (textField.getText().length() > length)
            label.setText(tooLong);
        else
            label.setText("");
    }

    /**
     * <p>changeLabelDatePicker.</p>
     *
     * @param textField a javafx.scene.control.DatePicker object.
     * @param label a javafx.scene.control.Label object.
     * @param isEmpty a {@link java.lang.String} object.
     */
    public void changeLabelDatePicker(DatePicker textField, Label label, String isEmpty) {
        if (textField.getEditor().getText().isEmpty())
            label.setText(isEmpty);
        else
            label.setText("");
    }

    /**
     * <p>changeLabelComboBox.</p>
     *
     * @param comboBox a javafx.scene.control.ComboBox object.
     * @param label a javafx.scene.control.Label object.
     * @param isEmpty a {@link java.lang.String} object.
     */
    public void changeLabelComboBox(ComboBox comboBox, Label label, String isEmpty) {
        if (comboBox.getSelectionModel().getSelectedItem() == null)
            label.setText(isEmpty);
        else
            label.setText("");
    }
}
