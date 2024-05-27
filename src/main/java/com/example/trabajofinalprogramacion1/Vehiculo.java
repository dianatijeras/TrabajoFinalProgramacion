package com.example.trabajofinalprogramacion1;

// Esta clase abstracta representa un vehiculo.

public abstract class Vehiculo {

    private String placa;
    private String modelo;
    private Propietario propietario;

    /**
     * Contrustor de la clase Vehiculo
     * @param placa
     * @param modelo
     * @param propietario
     */
    public Vehiculo(String placa, String modelo, Propietario propietario) {
        assert placa != null;
        assert modelo != null;

        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    /**
     * Getters y Setters
     */

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }


}
