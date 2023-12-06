package com.example.medict2_0;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Home {
    @Override
    public void start(Stage stage)throws Exception{
        Parent root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));

        Scene scene=new Scene(root);

        stage.setScene
    }

}
