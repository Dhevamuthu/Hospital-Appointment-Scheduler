package com.example.medict2_0;

import com.example.medict2_0.utils.DatabaseManager;
import com.example.medict2_0.utils.GlobalUser;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

public class DocAccController {

    @FXML
    private TextField HospitalTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private ComboBox<?> categoryComboBox;

    @FXML
    private PasswordField dataTextField;

    @FXML
    private RadioButton femaleRadioButton;

    @FXML
    private TextField mailTextField;

    @FXML
    private RadioButton maleRadioButton;

    @FXML
    private Button modifyButton;

    @FXML
    private TextField mredTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField specialityTextField;

   Connection connection= DatabaseManager.getDbInstance();
    public DocAccController() throws SQLException {
    }

    public void initialize() {
        String doctorID = GlobalUser.getUserId();

        /*try {
            String query = "SELECT * FROM doctor WHERE DID = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, doctorID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                nameTextField.setText(resultSet.getString("Name"));
                mredTextField.setText(resultSet.getString("MedicalRegId"));
                mailTextField.setText(resultSet.getString("Mailid"));
                numberTextField.setText(String.valueOf(resultSet.getInt("MedicalRegId")));
                // Set other fields accordingly
                // Example: HospitalTextField.setText(resultSet.getString("HID"));
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions accordingly
        }*/
    }
}
