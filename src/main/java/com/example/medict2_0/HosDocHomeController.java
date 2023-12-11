package com.example.medict2_0;

import com.example.medict2_0.model.Doctor;
import com.example.medict2_0.utils.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HosDocHomeController {

    @FXML
    private Button viewAppbutton;

    @FXML
    private Button MyAccount_button;

    @FXML
    private Button setScheduleButton;

    @FXML
    private Button logoutButton;

    public void setScheduleButtonOnAction(ActionEvent event){
        try{
            FXMLLoader setScheduleLoader = new FXMLLoader(getClass().getResource("Set_Schedule.fxml"));
            Parent setScheduleRoot= setScheduleLoader.load();
            Stage curSetSchedule = (Stage) setScheduleButton.getScene().getWindow();
            curSetSchedule.setScene(new Scene(setScheduleRoot));
            curSetSchedule.setTitle("Set Schedule page");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void viewAppbuttonOnAction(ActionEvent event){
        try{
            FXMLLoader viewAppLoader = new FXMLLoader(getClass().getResource("View_Appointment.fxml"));
            Parent viewAppRoot= viewAppLoader.load();
            Stage curViewApp = (Stage) viewAppbutton.getScene().getWindow();
            curViewApp.setScene(new Scene(viewAppRoot));
            curViewApp.setTitle("View Appointment page");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void logoutButtonOnAction(ActionEvent event){
        Alerts.showAlert("Logout", "Thank you for using MEDICT", Alert.AlertType.INFORMATION);

        Stage stage=(Stage) logoutButton.getScene().getWindow();
        stage.close();
    }
    public void initData(Doctor loggedInDoctor) {

    }

    // You can define initialize() method if you need to do something when the FXML is loaded
    // For example:
    // @FXML
    // public void initialize() {
    //    // Perform initialization tasks here
    // }

    // You can also define methods that respond to events, like button clicks, by using @FXML
    // For example:
    // @FXML
    // private void handleViewAppButtonAction() {
    //    // Logic for handling the "View Appointments" button click
    // }

    // Add more methods as needed to handle various actions/events
}
