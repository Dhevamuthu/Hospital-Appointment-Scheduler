package com.example.medict2_0;

import com.example.medict2_0.model.Patient;
import com.example.medict2_0.utils.Alerts;
import com.example.medict2_0.utils.GlobalUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientHomeController {

    @FXML
    private Button AppHistorybutton;

    @FXML
    private Button BookAppButton;

    @FXML
    private Button Homebutton;


    @FXML
    private Button myAccountButton;

    @FXML
    private Button logoutButton;

    public void BookAppButtonOnAction(ActionEvent event){
        try{
            FXMLLoader bookAppLoader = new FXMLLoader(getClass().getResource("Book_appointment.fxml"));
            Parent bookAppRoot= bookAppLoader.load();
            Stage curBookApp = (Stage) BookAppButton.getScene().getWindow();
            curBookApp.setScene(new Scene(bookAppRoot));
            curBookApp.setTitle("Appointment Booking page");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void logoutButtonOnAction(ActionEvent event){
        Alerts.showAlert("Logout", "Thank you for using MEDICT", Alert.AlertType.INFORMATION);

        Stage stage=(Stage) logoutButton.getScene().getWindow();
        stage.close();
        GlobalUser.setUserId(null);
    }

    public void myAccountButtonOnAction(ActionEvent event){
        try{
            FXMLLoader myAccLoader = new FXMLLoader(getClass().getResource("userProfile.fxml"));
            Parent myAccRoot= myAccLoader.load();
            Stage curMyAcc = (Stage) myAccountButton.getScene().getWindow();
            curMyAcc.setScene(new Scene(myAccRoot));
            curMyAcc.setTitle("Appointment Booking page");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void AppHistoryButtonOnAction(ActionEvent event){
        try{
            FXMLLoader appHisLoader = new FXMLLoader(getClass().getResource("app_his.fxml"));
            Parent appHisRoot= appHisLoader.load();
            Stage curAppHis = (Stage) AppHistorybutton.getScene().getWindow();
            curAppHis.setScene(new Scene(appHisRoot));
            curAppHis.setTitle("Appointment Booking page");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initData(Patient loggedInPatient) {
    }
}