module com.example.barsclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.barsclient to javafx.fxml;
    exports com.example.barsclient;
}