package com.example.medict2_0;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class doctor_accountController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField mredTextField;

    @FXML
    private TextField mailTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private TextField hospitalTextField;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private TextField specialityTextField;

    @FXML
    private PasswordField categoryTextField;

    @FXML
    private PasswordField dataTextField;

    @FXML
    private Button modifyButton;

    @FXML
    private Button cancelButton;

    private doctor doctor;


    @FXML
    public void modifyButton() {
        // Fetch data from the text fields
        String name = nameTextField.getText();
        String mred = mredTextField.getText();
        String mail = mailTextField.getText();
        String number = numberTextField.getText();
        String hospital = hospitalTextField.getText();
        String speciality = specialityTextField.getText();
        String category = categoryTextField.getText();
        String data = dataTextField.getText();

        boolean isMale = maleRadioButton.isSelected();
        boolean isFemale = femaleRadioButton.isSelected();



        if (doctor == null) {
            doctor = new doctor(name, mred, mail, number, hospital, speciality, category, data, isMale, isFemale);
        } else {
            // Assuming Doctor class has appropriate setter methods
            doctor.setName(name);
            doctor.setMred(mred);
            doctor.setMail(mail);
            doctor.setNumber(number);
            doctor.setHospital(hospital);
            doctor.setSpeciality(speciality);
            doctor.setCategory(category);
            doctor.setData(data);
            doctor.setMale(isMale);
            doctor.setFemale(isFemale);
        }
        System.out.println("Doctor details updated: " + doctor.toString());
    }
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
