package com.example.medict2_0;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class BookAppointmentController {

    @FXML
    private TextField timetextField;

    @FXML
    private ComboBox<String> cityCombo;

    @FXML
    private ComboBox<String> specialityCombo;

    @FXML
    private ComboBox<String> hospitalCombo;

    @FXML
    private ComboBox<String> doctorCombo;

    @FXML
    private DatePicker dateDatePicker;

    @FXML
    private Button SubmitButton;

    @FXML
    public void initialize() {
        // Add initialization code here if needed
        cityCombo.getItems().addAll("Chennai", "Coimbatore", "Salem");
        specialityCombo.getItems().addAll("Dentist", "Cardiologist", "Gynaecologist");
        hospitalCombo.getItems().addAll("PSG", "KMCH", "Apollo");
        doctorCombo.getItems().addAll("Ram", "Kavya", "Arun");
    }

    @FXML
    public void handleSubmitButtonAction() {
        String cityValue = cityCombo.getValue();
        String specialityValue = specialityCombo.getValue();
        String hospitalValue = hospitalCombo.getValue();
        String doctorValue = doctorCombo.getValue();

        if (cityValue == null || specialityValue == null || hospitalValue == null || doctorValue == null) {
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
