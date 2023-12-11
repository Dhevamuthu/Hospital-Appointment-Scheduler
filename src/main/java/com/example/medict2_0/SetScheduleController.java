package com.example.medict2_0;

import com.example.medict2_0.utils.DatabaseManager;
import com.example.medict2_0.utils.Alerts;
import com.example.medict2_0.utils.GlobalUser;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        try{
            Connection connection = DatabaseManager.getDbInstance();

            //hospitalCombo
            String hospitalQuery = "SELECT DISTINCT Name FROM hospital ORDER BY Name";
            PreparedStatement hospitalStmt = connection.prepareStatement(hospitalQuery);
            ResultSet hosResultSet = hospitalStmt.executeQuery();

            hospitalCombo.getItems().clear();

            while (hosResultSet.next()) {
                String doctorName = hosResultSet.getString("Name");
                hospitalCombo.getItems().add(doctorName);
            }
            hosResultSet.close();
            hospitalStmt.close();

            //durationCombo
            durationCombo.getItems().addAll("8 AM", "9 AM", "10 AM", "11 AM", "12 PM", "1 PM", "2 PM", "3 PM", "4 PM", "5 PM", "6 PM", "7 PM", "8 PM", "9PM");

            //slotCombo
            slotCombo.getItems().addAll("1", "2", "3","4","5","6","7","8");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void handleSubmitButtonAction() throws SQLException {
        Connection connection=DatabaseManager.getDbInstance();

        String durationValue = durationCombo.getValue();
        String hospitalValue = hospitalCombo.getValue();
        String slotValue = slotCombo.getValue();
        String dateValue = dateDatePicker.getValue() != null ? dateDatePicker.getValue().toString() : "";
        //String dt=dateValue+","+durationValue;


        if (durationValue == null || hospitalValue == null || slotValue == null || dateValue.isEmpty()) {
            Alerts.showAlert("Error", "Please fill in all the fields.", Alert.AlertType.ERROR);
        } else {

            //step 1: calculate ScID
            int oldScID=0;
            String schQuery = "SELECT ScID FROM schedule ORDER BY ScID DESC LIMIT 1";
            PreparedStatement schStmt = connection.prepareStatement(schQuery);

            //storing the result in result set:
            ResultSet schResultSet = schStmt.executeQuery();

            if (schResultSet.next()) {
                try {
                    oldScID = schResultSet.getInt(1);
                    oldScID = oldScID + 1;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }


            } else {
                oldScID=1;
            }
            System.out.println(oldScID);

            //step2: calculate HID
            String hosQuery = "SELECT HID FROM hospital where Name=(?)";
            PreparedStatement hosStmt = connection.prepareStatement(hosQuery);
            hosStmt.setString(1, hospitalValue);
            ResultSet hospitalResultSet = hosStmt.executeQuery();

            String hID = null;
            while (hospitalResultSet.next()) {
                hID = hospitalResultSet.getString("HID");
            }

            //retrieve DID:
            String userID = GlobalUser.getUserId();

            //finalstep
            try{
                String scheduleInsertQuery = "insert into schedule (ScID,DID,HID,Date,Time,Slots) values(?,?,?,?,?,?)";
                PreparedStatement scheduleInsertStatement = connection.prepareStatement(scheduleInsertQuery);

                System.out.println(oldScID + " " + userID + " " + hID + " "+ dateValue+" "+durationValue+" "+slotValue);
                scheduleInsertStatement.setString(1,String.valueOf(oldScID));
                scheduleInsertStatement.setString(2,userID);
                scheduleInsertStatement.setString(3, hID);
                scheduleInsertStatement.setString(4,dateValue);
                scheduleInsertStatement.setString(5,durationValue);
                scheduleInsertStatement.setString(6,slotValue);
                scheduleInsertStatement.executeUpdate();
                scheduleInsertStatement.close();
                Alerts.showAlert("Success", "Schedule details submitted successfully!", Alert.AlertType.INFORMATION);
                // You can perform additional actions here, like storing the data or navigating to another scene
                navigateToHomeWindow();
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
        navigateToHomeWindow();
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

            FXMLLoader loader = new FXMLLoader(getClass().getResource("HosDoc_home.fxml"));
            Parent root = loader.load();

            // Create a new scene
            Scene scene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) button.getScene().getWindow();

            // Set the scene to the stage
            stage.setScene(scene);


            // Show the stage
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
