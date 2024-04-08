package com.example.medict2_0;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AdminApplication.class.getResource("Admin_signup.fxml"));
        Parent root=fxmlLoader.load();
        AdminSignupController controller=fxmlLoader.getController();
        Scene scene = new Scene(root, 950, 950);
        stage.setTitle("Admin Page");
        Image icon=new Image("C:\\Users\\Dhevadharshini M\\IdeaProjects\\MEDICT2_0\\src\\main\\java\\com\\example\\medict2_0\\medict_logo.jpeg");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setX(0);
        stage.setY(0);
        stage.setWidth(1080);
        stage.setHeight(790);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}