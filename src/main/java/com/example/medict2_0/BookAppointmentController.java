package com.example.medict2_0;


import com.example.medict2_0.utils.DatabaseManager;
import com.example.medict2_0.utils.GlobalUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookAppointmentController {


    @FXML
    private ComboBox<String> cityCombo;

    @FXML
    private DatePicker dateDatePicker;

    @FXML
    private ComboBox<String> doctorCombo;

    @FXML
    private ComboBox<String> hospitalCombo;

    @FXML
    private ComboBox<String> specialtyCombo;

    @FXML
    private ComboBox<String> timeCombo;


    @FXML
    void handleSubmitButtonAction(ActionEvent event) throws SQLException {
        Connection connection = DatabaseManager.getDbInstance();

        String cityValue = cityCombo.getValue();
        String doctorValue = doctorCombo.getValue();
        String hospitalValue = hospitalCombo.getValue();
        String specialityValue = specialtyCombo.getValue();
        String timeValue = timeCombo.getValue();
        LocalDate dateValue = dateDatePicker.getValue();
        String formattedDate = dateValue.toString();

        if (cityValue == null || hospitalValue == null || specialityValue == null || timeValue == null || formattedDate.isEmpty()) {
            showAlert("Error", "Please fill in all the fields.");
            return;
        }

        //step 1: retrieve did,hid
        String doctorQuery = "SELECT DID,HID FROM doctor where Name=(?)";
        PreparedStatement doctorStmt = connection.prepareStatement(doctorQuery);
        doctorStmt.setString(1, doctorValue);
        ResultSet doctorResultSet = doctorStmt.executeQuery();

        String dID = null;
        String hID = null;
        while (doctorResultSet.next()) {
            dID = doctorResultSet.getString("DID");
            hID = doctorResultSet.getString("HID");
        }

        //step 2:retrieve sid
        String specialtyQuery = "SELECT SID FROM specialty where SName=(?)";
        PreparedStatement specialtyStmt = connection.prepareStatement(specialtyQuery);
        specialtyStmt.setString(1, specialityValue);
        ResultSet specialtyResultSet = specialtyStmt.executeQuery();

        String sID = null;
        while (specialtyResultSet.next()) {
            sID = specialtyResultSet.getString("SID");
        }

        //step 3:check with slots
        int scheduleSlots;
        String selectQuery = "Select slots from schedule where DID=(?) and HID=(?) and Date=(?) and Time=(?)";
        PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
        selectStmt.setString(1, dID);
        selectStmt.setString(2, hID);
        selectStmt.setString(3, formattedDate);
        selectStmt.setString(4, timeValue);

        ResultSet selectResultSet = selectStmt.executeQuery();

        if (selectResultSet.next()) {
            scheduleSlots = selectResultSet.getInt("Slots");

            if (scheduleSlots > 0) {
                //step 4: calculating the aid
                String strAID = null;
                String appQuery = "SELECT AID FROM appointment ORDER BY AID DESC LIMIT 1";
                PreparedStatement appStmt = connection.prepareStatement(appQuery);

                //storing the result in result set:
                ResultSet appResultSet = appStmt.executeQuery();

                if (appResultSet.next()) {
                    try {
                        strAID = appResultSet.getString(1);
                        int oldAID = (Integer.parseInt(strAID));
                        oldAID = oldAID + 1;
                        strAID = String.valueOf(oldAID);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }


                } else {
                    System.out.println("No rows found in the table");
                }

                //step 5: inserting in the  appointment table
                try {

                    Connection connection2=DatabaseManager.getDbInstance();
                    String userID = GlobalUser.getUserId();
                    String DT = formattedDate + "," + timeValue;
                    String insertQuery = "insert into appointment (AID,PID,DID,HID,SID,DT,status) values(?,?,?,?,?,?,?)";
                    PreparedStatement insertStatement = connection.prepareStatement(insertQuery);

                    System.out.println(strAID + " " + userID + " " + dID + " " + hID + " " + sID + " " + DT);
                    insertStatement.setString(1, strAID);
                    insertStatement.setString(2, userID);
                    insertStatement.setString(3, dID);
                    insertStatement.setString(4, hID);
                    insertStatement.setString(5, sID);
                    insertStatement.setString(6, DT);
                    insertStatement.setString(7, "Booked");
                    insertStatement.executeUpdate();
                    insertStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //Step 6: decrement slots by 1
                String updateQuery = "UPDATE schedule SET Slots = Slots - 1 " +
                        "WHERE DID = ? AND HID = ? AND Date = ? AND Time = ?";

                PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                updateStmt.setString(1, dID);
                updateStmt.setString(2, hID);
                updateStmt.setString(3, formattedDate);
                updateStmt.setString(4, timeValue);

                int rowsUpdated = updateStmt.executeUpdate();

                if (rowsUpdated > 0) {
                    showAlert("Booking Completed", "Appointment Booked Successfully");
                } else {
                    showAlert("Error", "Booking Failed");
                }
                updateStmt.close();
                appStmt.close();
                specialtyStmt.close();
                doctorStmt.close();

            } else {

                showAlert("Error", "Sorry! Appointment full");
            }
        } else {
            showAlert("Error", "Sorry! No slots available");
        }
        selectStmt.executeUpdate();
        selectStmt.close();

    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void initialize() {

        try {
            Connection connection2 = DatabaseManager.getDbInstance();

            //Step 1: doctorCombo
            String selectQuery = "SELECT DISTINCT Name FROM doctor ORDER BY Name";
            PreparedStatement selectStmt = connection2.prepareStatement(selectQuery);
            ResultSet resultSet = selectStmt.executeQuery();

            doctorCombo.getItems().clear();

            while (resultSet.next()) {
                String doctorName = resultSet.getString("Name");
                doctorCombo.getItems().add(doctorName);
            }
            resultSet.close();
            selectStmt.close();

            //Step 2: hospitalCombo
            String hosQuery = "SELECT DISTINCT Name FROM hospital ORDER BY Name";
            PreparedStatement hosStmt = connection2.prepareStatement(hosQuery);
            ResultSet hosSet = hosStmt.executeQuery();

            hospitalCombo.getItems().clear();

            while (hosSet.next()) {
                String hosName = hosSet.getString("Name");
                hospitalCombo.getItems().add(hosName);
            }

            //Step 3: specialtyCombo
            String specQuery = "SELECT DISTINCT SName FROM specialty ORDER BY SName";
            PreparedStatement specStmt = connection2.prepareStatement(specQuery);
            ResultSet specSet = specStmt.executeQuery();

            specialtyCombo.getItems().clear();

            while (specSet.next()) {
                String specName = specSet.getString("SName");
                specialtyCombo.getItems().add(specName);
            }

            cityCombo.getItems().addAll("Coimbatore", "Chennai", "Salem");

            timeCombo.getItems().addAll("8 AM", "9 AM", "10 AM", "11 AM", "12 PM", "1 PM", "2 PM", "3 PM", "4 PM", "5 PM", "6 PM", "7 PM", "8 PM", "9PM");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}