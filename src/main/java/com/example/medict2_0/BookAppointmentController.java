package com.example.medict2_0;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class BookAppointmentController {

    public Button SubmitButton;
    @FXML
    private TextField textField;

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private ComboBox<String> comboBox2;

    @FXML
    private ComboBox<String> comboBox3;

    @FXML
    private ComboBox<String> comboBox4;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button submitButton;

    @FXML
    public void initialize() {
        // Add initialization code here if needed
        comboBox1.getItems().addAll("Chennai", "Coimbatore", "Salem");
        comboBox2.getItems().addAll("Dentist", "Cardiologist", "Gynaecologist");
        comboBox3.getItems().addAll("PSG", "KMCH", "Apollo");
        comboBox4.getItems().addAll("Ram", "Kavya", "Arun");
    }

    @FXML
    public void handleSubmitButtonAction() {
        String combo1Value = comboBox1.getValue();
        String combo2Value = comboBox2.getValue();
        String combo3Value = comboBox3.getValue();
        String combo4Value = comboBox4.getValue();
        //String dateValue = datePicker.getValue() != null ? datePicker.getValue().toString() : "";

        if ( combo1Value == null || combo2Value == null || combo3Value == null || combo4Value == null) {
            showAlert("Error", "Please fill in all the fields.");
        } else {
            showAlert("Success", "Appointment details submitted successfully!");
            // You can perform additional actions here, like storing the data or navigating to another scene
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
