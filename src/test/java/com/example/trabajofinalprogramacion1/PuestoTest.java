package com.example.trabajofinalprogramacion1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PuestoTest {

    @Test
    public void estaOcupadoTest(){
        System.out.println("Inicio de prueba esta ocupado");
        Puesto puesto = new Puesto(1,5);
        Puesto puesto1 = new Puesto(4,9);
        Propietario propietario = new Propietario("John", "Garcia", "83839399");
        Vehiculo carro = new Carro("HJL098", "Honda", propietario);

        puesto.asignarVehiculo(carro);

        //Comprueba si los puestos estan ocupados
        assertTrue(puesto.estaOcupado());
        assertFalse(puesto1.estaOcupado());

        System.out.println("Fin de prueba esta ocupado");
    }

    @Test
    public void asignarVehiculoTest(){
        System.out.println("Inicio de prueba asignar vehiculo");
        Puesto puesto = new Puesto(8,7);
        Propietario propietario = new Propietario("Juana", "Diaz", "83939393");
        Vehiculo moto = new Moto("JLK098", "Honda", propietario, 180, TipoMoto.HIBRIDA);

        puesto.asignarVehiculo(moto);

        assertTrue(puesto.estaOcupado()); //Comprueba si el puesto esta ocupado
        assertEquals(moto, puesto.getVehiculo()); // comprueba si el vehicuo asignado al puesto es el mismo que se asigno

        System.out.println("Fin de prueba asignar vehiculo");
    }

    @Test
    public void desocuparPuestoTest(){
        System.out.println("Inicio de prueba desocupar puesto");
        Puesto puesto = new Puesto(4,10);
        Propietario propietario = new Propietario("Maria", "Ardila", "83839202");
        Vehiculo moto = new Moto("KQT678", "Yamaha", propietario, 120, TipoMoto.HIBRIDA);

        puesto.asignarVehiculo(moto);

        //Desocupa el puesto
        puesto.desocupar();

        assertFalse(puesto.estaOcupado()); //Comprueba si el puesto esta desocupado
        assertNull(puesto.getVehiculo()); //Comprueba si el vehiculo asociado al puesto es nulo

        System.out.println("Fin de prueba desocupar puesto");
    }
}
