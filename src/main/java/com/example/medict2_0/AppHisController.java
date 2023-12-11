package com.example.medict2_0;

import com.example.medict2_0.model.Appointment;
import com.example.medict2_0.utils.DatabaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppHisController {

    @FXML
    private TableView<Appointment> appHisTableView;

    @FXML
    private Button appQuitButton;

    @FXML
    private TableColumn<Appointment, String> appTable;

    @FXML
    private TableColumn<Appointment, String> docTable;

    @FXML
    private TableColumn<Appointment, String> dtTable;

    @FXML
    private TableColumn<Appointment, String> hosTable;

    @FXML
    private TableColumn<Appointment, String> specTable;

    @FXML
    private TableColumn<Appointment, String> statusTable;

    @FXML
    public void initialize() {
        initializeColumns();
        loadAppointments();
    }

    private void initializeColumns() {
        appTable.setCellValueFactory(new PropertyValueFactory<>("AID"));
        dtTable.setCellValueFactory(new PropertyValueFactory<>("DT"));
        docTable.setCellValueFactory(new PropertyValueFactory<>("DID"));
        hosTable.setCellValueFactory(new PropertyValueFactory<>("HID"));
        specTable.setCellValueFactory(new PropertyValueFactory<>("SID"));
        statusTable.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void loadAppointments() {
        try {
            Connection con = DatabaseManager.getDbInstance();
            ObservableList<Appointment> appointments = FXCollections.observableArrayList();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM appointment");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                appointments.add(new Appointment(
                        rs.getString("AID"),
                        rs.getString("PID"),
                        rs.getString("DID"),
                        rs.getString("HID"),
                        rs.getString("SID"),
                        rs.getString("DT"),
                        rs.getString("status")
                ));
            }

            appHisTableView.setItems(appointments);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void appQuitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) appQuitButton.getScene().getWindow();
        stage.close();
        navigateToPatHomeWindow1();
    }

    private void navigateToPatHomeWindow1() {
        try {
            // Load the FXML file for the home window
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Patient_home.fxml"));
            Parent root = loader.load();

            // Create a new scene
            Scene scene = new Scene(root);

            // Get the current stage
            Stage stage = (Stage) appQuitButton.getScene().getWindow();

            // Set the scene to the stage
            stage.setScene(scene);

            // Show the stage
            stage.show();
        } catch (IOException e) {
            // Print or log a more descriptive error message
            System.err.println("Error loading the FXML file: " + e.getMessage());
            e.printStackTrace(); // Handle the exception appropriately
        }
    }


}
