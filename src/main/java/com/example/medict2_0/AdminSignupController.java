package com.example.medict2_0;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;



public class AdminSignupController {
    @FXML
    private Button cancelButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField otherTextField;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField repasswordTextField;

    @FXML
    private Button registerButton;



    public void cancelButtonOnAction(ActionEvent event){
         Stage stage=(Stage) cancelButton.getScene().getWindow();
         stage.close();
             }
    public void registerButtonOnAction() {

        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String otherData = otherTextField.getText();
        String selectedValue = comboBox.getValue();
        //String password=passwordTextField.getText();
        //String repassword=repasswordTextField.getText();

        if (name.isEmpty() || email.isEmpty() || otherData.isEmpty() || selectedValue == null) {
            showAlert("Error", "Please fill in all the fields.");
            return;
        }

        showAlert("Registration Completed", "Registration successful!");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public void initialize(){
        comboBox.getItems().addAll("Coimbatore","Chennai","Salem");
                    }
    }