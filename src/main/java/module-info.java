module com.example.medict2_0 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.medict2_0 to javafx.fxml;
    exports com.example.medict2_0;
}