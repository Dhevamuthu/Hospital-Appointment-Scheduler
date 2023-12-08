package com.example.medict2_0;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ViewAppointmentController {

    @FXML
    private TreeTableView<?> treeTableView;

    @FXML
    private RadioButton viewAllRadioButton;

    @FXML
    private RadioButton viewWeekRadioButton;

    @FXML
    private RadioButton viewTodayRadioButton;

    @FXML
    private Button quitButton;

    @FXML
    private AnchorPane rootPane;

    @FXML
    public void initialize() {
        // Add initialization code here if needed
    }

    @FXML
    public void handleQuitButtonAction() {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }
}
