package com.example.medict2_0;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BookAppointmentApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Book_appointment.fxml"));
        Parent root = loader.load();

        // Set the controller for the FXML file
        BookAppointmentController controller = loader.getController();

        // Create the scene and set it on the stage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        // Set the stage title (optional)
        primaryStage.setTitle("Book an appointment");

        // Show the stage
        primaryStage.show();

        // Display your alert box here (code for alert box not provided)

        // After the alert box is displayed, execute the javaMail functionality
        executeJavaMail();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void executeJavaMail() {
        try {
            // Call the method in the javaMail class to execute the mail functionality
            javaMail.sendMail();
            System.out.println("Mail sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
