package com.example.trabajofinalprogramacion1;

/**
 * Clase Carro que hereda de Vehiculo
 */
public class Carro extends Vehiculo{

    /**
     * Constructor de la clase Carro
     * @param placa
     * @param modelo
     * @param propietario
     */
    public Carro(String placa, String modelo, Propietario propietario) {
        super(placa, modelo, propietario);
    }

}
