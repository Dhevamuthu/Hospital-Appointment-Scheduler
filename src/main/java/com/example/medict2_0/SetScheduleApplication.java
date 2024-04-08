package com.example.medict2_0;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class SetScheduleApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Set_Schedule.fxml"));
        primaryStage.setTitle("SET SCHEDULE");
        primaryStage.setScene(new Scene(root, 950, 669));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}