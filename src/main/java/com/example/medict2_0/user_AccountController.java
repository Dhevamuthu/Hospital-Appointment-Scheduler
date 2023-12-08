package com.example.medict2_0;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class user_AccountController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField dateTextField;

    @FXML
    private TextField mailTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField categoryTextField;

    @FXML
    private TextField dataTextField;

    @FXML
    private PasswordField passwordPasswordButton;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private Button modifyButton;

    @FXML
    private Button exitButton;

    @FXML
    public void modifyButton_OnAction() {
        // Fetch data from the text fields.
        String name = nameTextField.getText();
        String date = dateTextField.getText();
        String mail = mailTextField.getText();
        String number = numberTextField.getText();
        String address = addressTextField.getText();
        String category = categoryTextField.getText();
        String data = dataTextField.getText();
        String password = passwordPasswordButton.getText();
        boolean isMale = maleRadioButton.isSelected();
        boolean isFemale = femaleRadioButton.isSelected();

        // Update the database with the new data.

        // ...
    }




}
