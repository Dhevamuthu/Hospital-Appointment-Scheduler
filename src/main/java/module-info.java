module com.example.medict2_0 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.medict2_0.model to javafx.base;

    opens com.example.medict2_0 to javafx.fxml;
    exports com.example.medict2_0;
}