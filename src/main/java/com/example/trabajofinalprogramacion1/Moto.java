package com.example.trabajofinalprogramacion1;

//Clase Moto que hereda de la clase Vehiculo
public class Moto extends Vehiculo{

    private int velocidadMaxima;
    private TipoMoto tipoMoto; // CLASICA O HIBRIDA

    /**
     * Constructor de la clase Moto
     * @param placa
     * @param modelo
     * @param propietario
     * @param velocidadMaxima
     * @param tipoMoto
     */
    public Moto(String placa, String modelo, Propietario propietario, int velocidadMaxima, TipoMoto tipoMoto) {
        super(placa, modelo, propietario);
        this.velocidadMaxima = velocidadMaxima;
        this.tipoMoto = tipoMoto;
    }

    /**
     * Getters y Setters
     */
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        assert velocidadMaxima >= 0;

        this.velocidadMaxima = velocidadMaxima;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(TipoMoto tipoMoto) {
        this.tipoMoto = tipoMoto;
    }


}
