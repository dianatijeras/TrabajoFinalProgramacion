module com.example.trabajofinalprogramacion1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trabajofinalprogramacion1 to javafx.fxml;
    exports com.example.trabajofinalprogramacion1;
}