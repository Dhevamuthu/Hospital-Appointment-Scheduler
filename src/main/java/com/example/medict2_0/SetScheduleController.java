package com.example.medict2_0;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import java.io.IOException;

public class SetScheduleController {

    @FXML
    private ComboBox<String> hospitalCombo;

    @FXML
    private ComboBox<String> durationCombo;

    @FXML
    private ComboBox<String> slotCombo;

    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private Button button;

    @FXML
    public void initialize() {
        // Add initialization code here if needed
        hospitalCombo.getItems().addAll("PSG", "APOLLO", "KMCH");
        durationCombo.getItems().addAll("8 am", "9 am", "11 am");
        slotCombo.getItems().addAll("Slot 1", "Slot 2", "Slot 3");
    }

    @FXML
    public void handleSubmitButtonAction() {
        String durationValue = durationCombo.getValue();
        String hospitalValue = hospitalCombo.getValue();
        String slotValue = slotCombo.getValue();
        String dateValue = dateDatePicker.getValue() != null ? dateDatePicker.getValue().toString() : "";

        if (durationValue == null || hospitalValue == null || slotValue == null || dateValue.isEmpty()) {
            showAlert("Error", "Please fill in all the fields.");
        } else {
            showAlert("Success", "Schedule details submitted successfully!");
            // You can perform additional actions here, like storing the data or navigating to another scene
            navigateToHomeWindow();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void navigateToHomeWindow() {
        try {
            // Load the FXML file for the home window

            FXMLLoader loader = new FXMLLoader(getClass().getResource("View_Appointment.fxml"));
            Parent root = loader.load();

            // Create a new scene
            Scene scene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) button.getScene().getWindow();

            // Set the scene to the stage
            stage.setScene(scene);

            // Optional: You can set additional properties or pass data to the controller of the new scene
            // HomeController homeController = loader.getController();
            // homeController.initializeData(...);

            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
