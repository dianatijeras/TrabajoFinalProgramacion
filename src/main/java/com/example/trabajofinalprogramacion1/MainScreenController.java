package com.example.trabajofinalprogramacion1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import java.time.LocalDateTime;

public class ParqueaderoController {

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtDocumento;
    @FXML
    private TextField txtFila;
    @FXML
    private TextField txtColumna;

    @FXML
    private TextField txtPropietario;

    @FXML
    private TextField txtVelocidadMaxima;

    @FXML
    private TextField txtTipoMoto;

    @FXML
    private TextField txtPuestoI;

    @FXML
    private TextField txtPuestoJ;

    @FXML
    private TextArea txtAreaReporte;

    @FXML
    private Button btnRegistrarIngreso;

    @FXML
    private Button btnGenerarReporteDiario;

    @FXML
    private Button btnGenerarReporteMensual;

    private Parqueadero parqueadero;

    public ParqueaderoController() {
        parqueadero = new Parqueadero("Te Lo Estacionamos", 100);
    }

    @FXML
    private void handleRegistrarIngreso() {
        String placa = txtPlaca.getText();
        String modelo = txtModelo.getText();
        String nombre = txtNombre.getText(); // Campo de texto para el nombre del propietario
        String apellido = txtApellido.getText(); // Campo de texto para el apellido del propietario
        String documento = txtDocumento.getText(); // Campo de texto para el documento del propietario
        int fila = Integer.parseInt(txtFila.getText()); // Obtiene la fila ingresada por el usuario
        int columna = Integer.parseInt(txtColumna.getText()); // Obtiene la columna ingresada por el usuario

        if (!placa.isEmpty() && !modelo.isEmpty() && !nombre.isEmpty() && !apellido.isEmpty() && !documento.isEmpty()) {
            if (fila >= 0 && fila < 100 && columna >= 0 && columna < 100) { // Verifica que la fila y la columna estén dentro del rango permitido
                if (parqueadero.verificarDisponibilidadPusto(fila, columna)) {
                    // Verificar si es moto o carro
                    if (!txtVelocidadMaxima.getText().isEmpty() && !txtTipoMoto.getText().isEmpty()) {
                        int velocidadMaxima = Integer.parseInt(txtVelocidadMaxima.getText());
                        TipoMoto tipoMoto = TipoMoto.valueOf(txtTipoMoto.getText().toUpperCase());
                        Moto moto = new Moto(placa, modelo, new Propietario(nombre, apellido, documento), velocidadMaxima, tipoMoto);
                        parqueadero.registrarIngreso(moto, fila, columna);
                    } else {
                        Carro carro = new Carro(placa, modelo, new Propietario(nombre, apellido, documento));
                        parqueadero.registrarIngreso(carro, fila, columna);
                    }
                    txtAreaReporte.appendText("Ingreso registrado correctamente.\n");
                } else {
                    txtAreaReporte.appendText("El puesto especificado está ocupado.\n");
                }
            } else {
                txtAreaReporte.appendText("La fila y la columna deben estar entre 0 y 99.\n");
            }
        } else {
            txtAreaReporte.appendText("Por favor, complete todos los campos.\n");
        }
    }


    @FXML
    private void handleGenerarReporteDiario() {
        LocalDateTime fechaActual = LocalDateTime.now();
        parqueadero.generarReporteDiario(fechaActual);
        txtAreaReporte.appendText("Reporte diario generado.\n");
    }

    @FXML
    private void handleGenerarReporteMensual() {
        // Obtener mes y año actual
        int mesActual = LocalDateTime.now().getMonthValue();
        int anioActual = LocalDateTime.now().getYear();
        parqueadero.generarReporteMensual(mesActual, anioActual);
        txtAreaReporte.appendText("Reporte mensual generado.\n");
    }
}



