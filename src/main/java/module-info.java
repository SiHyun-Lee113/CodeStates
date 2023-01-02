module com.example.codestates {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.codestates to javafx.fxml;
    exports com.example.codestates;
}