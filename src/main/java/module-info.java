module org.example.otp2wk4ha {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires java.desktop;


    opens org.example.otp2wk4ha to javafx.fxml;
    exports org.example.otp2wk4ha;
}