package com.example.trabajofinalprogramacion1;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PropietarioTest {

    @Test
    public void agregarVehiculoTest(){
        System.out.println("Inicio de prueba agregar vehiculo");
        Propietario propietario = new Propietario("Diana", "Garcia", "72828282");
        Vehiculo carro = new Carro("BJK098", "Honda", propietario);
        Vehiculo carro2 = new Carro("JJJ987", "Nissan", propietario);

        propietario.agregarVehiculo(carro);
        propietario.agregarVehiculo(carro2);

        assertEquals(2, propietario.getVehiculos().size()); //Verifica que el tamaño de la lista de vehiculos sea 2
        assertEquals(carro, propietario.getVehiculos().get(0));
        assertEquals(carro2, propietario.getVehiculos().get(1));

        System.out.println("Propietario: " + propietario.getNombre() + " " + propietario.getApellido());
        System.out.println("Vehiculos agregados: ");
        for (Vehiculo vehiculo : propietario.getVehiculos()){ //Itera sobre la lista de vehiculos del propietario
            System.out.println(" - " + vehiculo.getPlaca() + "- " + vehiculo.getModelo()); //Imprime la placa y el modelo de cada vehiculo
        }
        System.out.println("Fin de prueba agregar vehiculo");
    }

}
