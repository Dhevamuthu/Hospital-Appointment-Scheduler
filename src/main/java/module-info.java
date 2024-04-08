module com.example.medict2_ {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.mail;
    requires java.sql;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires com.ibm.icu;


    opens com.example.medict2_0 to javafx.fxml;
    exports com.example.medict2_0;
}