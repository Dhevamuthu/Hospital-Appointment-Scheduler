package com.example.medict2_0;

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

}
