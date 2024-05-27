package com.example.trabajofinalprogramacion1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main extends Application {

    // Instancia del parqueadero
    private Parqueadero parqueadero;

    @Override
    public void start(Stage primaryStage) {
        // Crear una instancia del parqueadero
        parqueadero = new Parqueadero("Mi Parqueadero", 100);

        // Crear la interfaz gráfica
        primaryStage.setTitle("Sistema de Parqueadero");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Elementos de la interfaz
        Label labelTitulo = new Label("Sistema de Parqueadero");
        Button btnRegistrarIngreso = new Button("Registrar Ingreso");
        Button btnGenerarReporteDiario = new Button("Generar Reporte Diario");
        Button btnGenerarReporteMensual = new Button("Generar Reporte Mensual");

        // Evento para registrar ingreso
        btnRegistrarIngreso.setOnAction(event -> mostrarVentanaRegistroIngreso());

        // Evento para generar reporte diario
        btnGenerarReporteDiario.setOnAction(event -> generarReporteDiario());

        // Evento para generar reporte mensual
        btnGenerarReporteMensual.setOnAction(event -> mostrarFormularioReporteMensual());

        // Añadir elementos al grid
        grid.add(labelTitulo, 0, 0, 2, 1);
        grid.add(btnRegistrarIngreso, 0, 1);
        grid.add(btnGenerarReporteDiario, 0, 2);
        grid.add(btnGenerarReporteMensual, 0, 3);

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para mostrar la ventana de registro de ingreso
    private void mostrarVentanaRegistroIngreso() {
        Stage ventanaRegistro = new Stage();
        ventanaRegistro.setTitle("Registrar Ingreso");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label lblPlaca = new Label("Placa:");
        TextField txtPlaca = new TextField();
        Label lblModelo = new Label("Modelo:");
        TextField txtModelo = new TextField();
        Label lblPropietario = new Label("Propietario:");
        TextField txtPropietario = new TextField();
        Button btnRegistrar = new Button("Registrar");

        // Evento para registrar el ingreso
        btnRegistrar.setOnAction(event -> {
            String placa = txtPlaca.getText();
            String modelo = txtModelo.getText();
            String propietario = txtPropietario.getText();

            Propietario nuevoPropietario = new Propietario(propietario, "", "");
            Vehiculo nuevoVehiculo = new Carro(placa, modelo, nuevoPropietario);

            parqueadero.registrarIngreso(nuevoVehiculo, 0, 0); // Se registra en la posición 0,0 por ejemplo

            ventanaRegistro.close();
        });

        // Añadir elementos al grid
        grid.add(lblPlaca, 0, 0);
        grid.add(txtPlaca, 1, 0);
        grid.add(lblModelo, 0, 1);
        grid.add(txtModelo, 1, 1);
        grid.add(lblPropietario, 0, 2);
        grid.add(txtPropietario, 1, 2);
        grid.add(btnRegistrar, 0, 3, 2, 1);

        Scene scene = new Scene(grid, 300, 200);
        ventanaRegistro.setScene(scene);
        ventanaRegistro.show();
    }

    // Método para generar el reporte diario
    private void generarReporteDiario() {
        LocalDateTime fechaActual = LocalDateTime.now();
        parqueadero.generarReporteDiario(fechaActual);
    }

    // Método para mostrar el formulario de generación de reporte mensual
    private void mostrarFormularioReporteMensual() {
        Stage ventanaReporteMensual = new Stage();
        ventanaReporteMensual.setTitle("Generar Reporte Mensual");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label lblMes = new Label("Mes:");
        TextField txtMes = new TextField();
        Label lblAnio = new Label("Año:");
        TextField txtAnio = new TextField();
        Button btnGenerar = new Button("Generar");

        // Evento para generar el reporte mensual
        btnGenerar.setOnAction(event -> {
            int mes = Integer.parseInt(txtMes.getText());
            int anio = Integer.parseInt(txtAnio.getText());

            parqueadero.generarReporteMensual(mes, anio);

            ventanaReporteMensual.close();
        });

        // Añadir elementos al grid
        grid.add(lblMes, 0, 0);
        grid.add(txtMes, 1, 0);
        grid.add(lblAnio, 0, 1);
        grid.add(txtAnio, 1, 1);
        grid.add(btnGenerar, 0, 2, 2, 1);

        Scene scene = new Scene(grid, 300, 150);
        ventanaReporteMensual.setScene(scene);
        ventanaReporteMensual.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
