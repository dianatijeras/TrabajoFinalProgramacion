package com.example.trabajofinalprogramacion1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class MainScreenController {

    @FXML
    private Button registrarIngresoButton;

    @FXML
    private Button generarReporteDiarioButton;

    @FXML
    private Button generarReporteMensualButton;

    @FXML
    private void handleRegistrarIngreso(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VehicleTypeScreen.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) registrarIngresoButton.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private void handleGenerarReporteDiario(ActionEvent event) {
        // Lógica para generar el reporte diario
    }

    @FXML
    private void handleGenerarReporteMensual(ActionEvent event) {
        // Lógica para generar el reporte mensual
    }
}

