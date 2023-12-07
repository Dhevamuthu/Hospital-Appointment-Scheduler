package com.example.medict2_0;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    @FXML
    private ImageView doctor;

    @FXML
    private Button doctorButton;

    @FXML
    private ImageView hospital;

    @FXML
    private Button hospitalButton;

    @FXML
    private Button patientButton;

    public void doctorButtonOnAction(ActionEvent event){
        try{
            FXMLLoader doctorLoader = new FXMLLoader(getClass().getResource("Doctor_Signup.fxml"));
            Parent doctorRoot= doctorLoader.load();
            Stage curDoctor = (Stage) doctorButton.getScene().getWindow();
            curDoctor.setScene(new Scene(doctorRoot));
            curDoctor.setTitle("Doctor Registration page");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void hospitalButtonOnAction(ActionEvent event){
        try{
            FXMLLoader hospitalLoader = new FXMLLoader(getClass().getResource("Hospital_Signup.fxml"));
            Parent hospitalRoot= hospitalLoader.load();
            Stage curHospital = (Stage) hospitalButton.getScene().getWindow();
            curHospital.setScene(new Scene(hospitalRoot));
            curHospital.setTitle("Hospital Registration page");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void patientButtonOnAction(ActionEvent event){
        try{
            FXMLLoader patientLoader = new FXMLLoader(getClass().getResource("patient_Signup.fxml"));
            Parent patientRoot= patientLoader.load();
            Stage curPatient = (Stage) patientButton.getScene().getWindow();
            curPatient.setScene(new Scene(patientRoot));
            curPatient.setTitle("Patient Registration page");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



}
