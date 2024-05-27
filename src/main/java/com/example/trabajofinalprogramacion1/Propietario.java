package com.example.trabajofinalprogramacion1;

import java.util.ArrayList;
import java.util.List;

// Esta clase representa a un propietario de vehiculos
// y contiene su nombre, apellido, documento y una lista de vehiculos que posee.
// los vehiculos son agregados a esta lista utilizando el metodo agregarVehiculo


public class Propietario {

    private String nombre;
    private String apellido;
    private String documento;
    private List<Vehiculo> vehiculos;

    /**
     * constructor de la clase Propietario
     * @param nombre
     * @param apellido
     * @param documento
     */
    public Propietario (String nombre, String apellido, String documento){
        assert nombre != null;
        assert apellido != null;
        assert documento != null;

        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.vehiculos = new ArrayList<>();
    }

    /**
     * Getters y Setters
     */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Metodo para agregar un vehiculo a la lista de vehiculos de un propietario
     * @param vehiculo
     */
    public void agregarVehiculo(Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
    }


}