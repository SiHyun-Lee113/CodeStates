module com.example.codestates {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.codestates to javafx.fxml;
    exports com.example.codestates;
    exports com.example.codestates.Lamda;
    opens com.example.codestates.Lamda to javafx.fxml;
}