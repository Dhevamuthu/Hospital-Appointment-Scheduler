package com.example.medict2_0;

import com.example.medict2_0.utils.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HospitalRegController {

    @FXML
    private TextField HregidTextField;

    @FXML
    private Button RegisterButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private ImageView registerButton;

    @FXML
    private TextField repasswordTextField;

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void registerButtonOnAction() {
        try {
            Connection connection = DatabaseManager.getDbInstance();
            String name = nameTextField.getText();
            String email = emailTextField.getText();
            String number = numberTextField.getText();
            String selectedValue = comboBox.getValue();
            String password = passwordTextField.getText();
            String re_password = repasswordTextField.getText();
            String hosRegID = HregidTextField.getText();

            //int num = Integer.parseInt(number);
            //int hRegId = Integer.parseInt(hosRegID);

            if (name.isEmpty() || email.isEmpty() || number.isEmpty() || selectedValue == null) {
                showAlert("Error", "Please fill in all the fields.");
                return;
            }
            if (!password.equals(re_password)) {
                showAlert("Error", "Passwords do not match. Please retry.");
                return;
            }

            String lastHID = null;
            String lastHID2=null;
            String selectQuery = "SELECT * FROM hospital ORDER BY HID DESC LIMIT 1";
            PreparedStatement selectStmt = connection.prepareStatement(selectQuery);

                //storing the result in result set:
            ResultSet resultSet = selectStmt.executeQuery();

            if (resultSet.next()) {
                try{
                    lastHID = resultSet.getString(1);
                    lastHID2=lastHID.substring(1);
                    int oldID=(Integer.parseInt(lastHID2))+1;
                    lastHID2=String.valueOf(oldID);
                    lastHID="H"+lastHID2;
                }
                catch (NumberFormatException e){ e.printStackTrace();}


            } else {
                System.out.println("No rows found in the table");
            }

            String query = "Insert into hospital (HID,Name,Location,ContactNumber,Mailid,Password,HRefId) values(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            //String hid = "H006";
            statement.setString(1, lastHID);
            statement.setString(2, name);
            statement.setString(4, number);
            statement.setString(3, selectedValue);
            statement.setString(5, email);
            statement.setString(6, password);
            statement.setString(7, hosRegID);
            if (statement.executeUpdate() > 0) {
                showAlert("Registration Completed", "User successfully registered!");
            } else {
                showAlert("Error", "User registration failed. Please try again.");
            }
            statement.executeUpdate();
            statement.close();
            connection.close();
        }
        catch (Exception e){ e.printStackTrace();}
        navigateToLoginWindow();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void navigateToLoginWindow() {
        try {
            // Load the FXML file for the home window

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();

            // Create a new scene
            Scene scene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) registerButton.getScene().getWindow();

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
    public void initialize(){
        comboBox.getItems().addAll("Coimbatore","Chennai","Salem");
    }
}


