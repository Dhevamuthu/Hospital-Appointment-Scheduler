package com.example.medict2_0;

import com.example.medict2_0.utils.Alerts;
import com.example.medict2_0.utils.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

        if (!userID.isEmpty()) {
            //String checkUserID = userID.substring(0, 1);
            //checkUserID = checkUserID.toUpperCase();
            System.out.println(userID);
            if (userID.startsWith("P") || userID.startsWith("p")) {
                String selectQuery = "SELECT password FROM patient WHERE PID=(?)";
                PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
                selectStmt.setString(1, userID);
                ResultSet resultSet = selectStmt.executeQuery();
                if (resultSet.next()) {
                    String checkPassword = resultSet.getString("Password");
                    System.out.println(checkPassword);
                    if (checkPassword.equals(pass)) {
                        Alerts.showAlert("Welcome", "Login Successful!");

                        try{
                            FXMLLoader patientHomeLoader = new FXMLLoader(getClass().getResource("Patient_home.fxml"));
                            Parent patientHomeRoot= patientHomeLoader.load();
                            Stage curPatientHome = (Stage) loginButton.getScene().getWindow();
                            curPatientHome.setScene(new Scene(patientHomeRoot));
                            curPatientHome.setTitle("Patient Home page");
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }

                    } else { Alerts.showAlert("Error", "Invalid Password. Please try again.");}
                }
            } else { Alerts.showAlert("Error", "INVALID ENTRY");}
        } else { Alerts.showAlert("Error", "Enter all the fields");}




    }

}
