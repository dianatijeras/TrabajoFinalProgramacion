package com.example.trabajofinalprogramacion1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

// representa un registro de ingreso de un vehiculo a un puesto en el parqueadero

public class Ingreso {

    private Puesto puesto; //Puesto ocupado por el vehiculo
    private Vehiculo vehiculo; //Vehiculo que ingreso al parqueadero
    private LocalDateTime fechaIngreso; //fecha y hora en que se registro el ingreso
    private LocalDateTime fechaSalida;

    /**
     * constructor de la clase ingreso
     * @param puesto
     * @param vehiculo
     */
    public Ingreso(Puesto puesto, Vehiculo vehiculo) {
        this.puesto = puesto;
        this.vehiculo = vehiculo;
        this.fechaIngreso = LocalDateTime.now(); //Establece la fecha y hora actual del sistema
        this.fechaSalida = null; //Inicialmente la fecha de salida es null
    }

    /**
     * Setters y Getters
     */
    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
