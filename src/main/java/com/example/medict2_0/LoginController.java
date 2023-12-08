package com.example.medict2_0;

import com.example.medict2_0.model.Doctor;
import com.example.medict2_0.model.Patient;
import com.example.medict2_0.utils.Alerts;
import com.example.medict2_0.utils.DatabaseManager;
import com.example.medict2_0.utils.GlobalUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Button cancelButton;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registerButton;

    @FXML
    private TextField userTextField;

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();

    }

    public void registerButtonOnAction(ActionEvent event){
        try{
            FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("signup.fxml"));
            Parent registerRoot= registerLoader.load();
            Stage curRegister = (Stage) registerButton.getScene().getWindow();
            curRegister.setScene(new Scene(registerRoot));
            curRegister.setTitle("Registration page");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loginButtonOnAction(ActionEvent event) throws SQLException {
        Connection connection = DatabaseManager.getDbInstance();
        String userID = userTextField.getText();
        String pass = passwordTextField.getText();
        GlobalUser.setUserId(userID);

        if (!userID.isEmpty()) {
            if (userID.startsWith("P") || userID.startsWith("p")) {
                String selectQuery = "SELECT password FROM patient WHERE PID=?";
                try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
                    selectStmt.setString(1, userID);
                    try (ResultSet resultSet = selectStmt.executeQuery()) {
                        if (resultSet.next()) {
                            String checkPassword = resultSet.getString("Password");
                            if (checkPassword.equals(pass)) {
                                Alerts.showAlert("Welcome", "Login Successful!", Alert.AlertType.INFORMATION);

                                // Create a Patient object and set its properties
                                Patient loggedInPatient = new Patient();
                                loggedInPatient.setPID(userID);
                                // Set other properties as needed

                                // Proceed to the next screen using the logged-in patient object
                                goToPatientHome(loggedInPatient);
                            } else {
                                Alerts.showAlert("Warning", "Invalid Password. Please try again.",Alert.AlertType.WARNING);
                            }
                        }
                    }
                }
            } else if(userID.startsWith("D") || userID.startsWith("d")) {
                String dSelectQuery = "SELECT password FROM doctor WHERE DID=?";
                try (PreparedStatement dSelectStmt = connection.prepareStatement(dSelectQuery)) {
                    dSelectStmt.setString(1, userID);
                    try (ResultSet dResultSet = dSelectStmt.executeQuery()) {
                        if (dResultSet.next()) {
                            String dCheckPassword = dResultSet.getString("Password");
                            if (dCheckPassword.equals(pass)) {
                                Alerts.showAlert("Welcome", "Login Successful!", Alert.AlertType.INFORMATION);

                                // Create a Patient object and set its properties
                                Doctor loggedInDoctor = new Doctor();
                                loggedInDoctor.setDID(userID);
                                // Set other properties as needed

                                // Proceed to the next screen using the logged-in patient object
                                goToDoctorHome(loggedInDoctor);
                            } else {
                                Alerts.showAlert("Warning", "Invalid Password. Please try again.",Alert.AlertType.WARNING);
                            }
                        }
                    }
                }

            }
        }
        else {
            Alerts.showAlert("Error", "Enter all the fields",Alert.AlertType.ERROR);
        }
    }

    private void goToPatientHome(Patient loggedInPatient) {
        try {
            FXMLLoader patientHomeLoader = new FXMLLoader(getClass().getResource("Patient_home.fxml"));
            Parent patientHomeRoot = patientHomeLoader.load();
            Stage curPatientHome = (Stage) loginButton.getScene().getWindow();
            curPatientHome.setScene(new Scene(patientHomeRoot));

            // Access the controller of the next screen and pass the logged-in patient object
            PatientHomeController patientHomeController = patientHomeLoader.getController();
            patientHomeController.initData(loggedInPatient);

            curPatientHome.setTitle("Patient Home page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void goToDoctorHome(Doctor loggedInDoctor) {
        try {
            FXMLLoader hosDocHomeLoader = new FXMLLoader(getClass().getResource("HosDoc_home.fxml"));
            Parent doctorHomeRoot = hosDocHomeLoader.load();
            Stage curDoctorHome = (Stage) loginButton.getScene().getWindow();
            curDoctorHome.setScene(new Scene(doctorHomeRoot));

            // Access the controller of the next screen and pass the logged-in patient object
            HosDocHomeController hosDocHomeController = hosDocHomeLoader.getController();
            hosDocHomeController.initData(loggedInDoctor);

            curDoctorHome.setTitle("Doctor Home page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
