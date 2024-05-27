package com.example.trabajofinalprogramacion1;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class ParqueaderoTest {


    @Test
    public void encotrarPuestoTest() {
        System.out.println("Inicio de prueba encontar puesto");

        Parqueadero parqueadero = new Parqueadero("Te Lo Estacionamos", 100);
        Vehiculo carro = new Carro("ABH785", "Toyota", new Propietario("Diana", "Garcia", "17383837"));
        Puesto puesto = parqueadero.getMatrizPuestos()[2][3];
        puesto.setVehiculo(carro);

        //Comprueba si el metodo encontrarPuesto devuelve el puesto esperado
        assertEquals(puesto, parqueadero.encontrarPuesto(2, 3));

        System.out.println("Fin de prueba encontrar puesto");
    }

    @Test
    //salida true
    public void VerificarDisponibilidadPuestoTest() {
        System.out.println("Inicio de pruebas para veirifar disponibilidad de puesto: ");

        Parqueadero parqueadero = new Parqueadero("Te Lo Estacionamos", 100);

        //Comprueba si el metodo verificarDisponibilidadPuesto devuelve true para un puesto especifico
        assertTrue(parqueadero.verificarDisponibilidadPusto(5, 3));

        System.out.println("Fin de prueba verificar disponibilidad de puesto");
    }

    @Test
    //coordenadas fuera del rango
    public void verificarDisponibilidadPuestooTest() {
        System.out.println("Inicio de prueba verificar disponibilidad de puesto");

        Parqueadero parqueadero = new Parqueadero("Te Lo Estacionamos", 100);

        //Comprueba si el metodo verificarDisponibilidadPuesto devulve false para coordenadas fuera del rango
        assertFalse(parqueadero.verificarDisponibilidadPusto(101, 200));

        System.out.println("Fin de prueba verificar disponibilidad de puesto");
    }

    @Test
    public void registrarDosVehiculosMismoPuesto(){
        System.out.println("Inicio de prueba registrar 2 vehiculos en el mismo puesto");

        Parqueadero parqueadero = new Parqueadero("Te Lo Estacionamos", 100);

        Vehiculo moto = new Moto("BCH764", "Suzuki", new Propietario("Diana", "Garcia", "178836353"), 200, TipoMoto.HIBRIDA);
        Vehiculo moto2 = new Moto("UIY789", "Suzuki", new Propietario("Sara", "Martinez", "7928272"), 150, TipoMoto.HIBRIDA);

        parqueadero.registrarIngreso(moto, 9,5);

        //Verifica que se lance una excepcion cuando se intenta registrar el segundo vehiculo en el mismo puesto
        assertThrows(Throwable.class, () -> parqueadero.registrarIngreso(moto2, 9, 5));

        System.out.println("Fin de prueba registrar 2 vehiculos en el mismo puesto");
    }

    @Test
    public void identificarPropietarioTest() {
        System.out.println("Inicio de prueba identificar Propietario");

        Parqueadero parqueadero = new Parqueadero("Te Lo Estacionamos", 99);
        Vehiculo moto = new Moto("BCH764", "Suzuki", new Propietario("Diana", "Garcia", "178836353"), 200, TipoMoto.HIBRIDA);

        parqueadero.registrarIngreso(moto, 10, 6);

        //Identifica el propietario del vehiculo en el puesto especifico
        Propietario propietario = parqueadero.identificarPropietario(10, 6);

        //Comprueba que el nombre del propietario identificado sea el que se ingreso
        assertEquals("Diana", propietario.getNombre());

        System.out.println("nombre del propietario es: " + propietario.getNombre());
        System.out.println("Fin de prueba identificar propietario");

    }

    @Test
    public void registrarIngresooTest() {
        System.out.println("Inicio de prueba registar ingreso");

        Parqueadero parqueadero = new Parqueadero("Te Lo Estacionamos", 100);
        Carro carro = new Carro("ABC689", "Toyota", new Propietario("Diana", "Garcia", "788762"));

        parqueadero.registrarIngreso(carro, 5, 7);

        assertEquals(1, parqueadero.getListIngresos().size()); //Verifica que solo haya un ingreso en la lista de ingresos
        assertEquals(carro, parqueadero.getListIngresos().get(0).getVehiculo()); //Verifica que el vehiculo registrado sea el mismo que el registrado en el ingreso

        System.out.println("Fin de prueba registrar ingreso");
    }


    @Test
    public void calcularCostoEstacionamientooTest() {
        System.out.println("Inicio de prueba calcular costo estacionamiento");

        Parqueadero parqueadero = new Parqueadero("Te Lo Estacionamos", 100);
        Vehiculo carro = new Carro("HKJ567", "Toyota", new Propietario("Diana", "Garcia", "799383"));

        parqueadero.registrarIngreso(carro, 2, 8);
        parqueadero.setTarifaCarro(2.5);

        LocalDateTime fechaIngreso = LocalDateTime.now();
        //Establecer la fecha de saida (3 horas despues del ingreso)
        LocalDateTime fechaSalida = fechaIngreso.plusHours(3);

        double costo = parqueadero.calcularCostoEstacionamiento(carro, fechaSalida);

        //Verifica que el costo calculado sea el esperado (7.5)
        assertEquals(7.5, costo, 0.01, "El costo deberia ser 7.5");

        System.out.println("Fin de la prueba calcular costo de estacionamiento");
    }

    @Test
    public void vehiculoOcupaPuestoTest(){
        System.out.println("Inicio de obtener vehiculo ocupa un puesto");

        Parqueadero parqueadero = new Parqueadero("Te Lo Estacionamos", 100);
        Vehiculo carro = new Carro("DIS567", "Toyota", new Propietario("Nathali", "Alzate", "7838393"));

        parqueadero.registrarIngreso(carro, 9, 8);

        //Verifica si el vehiculo registrado ocupa un puesto en el parqueadero
        boolean vehiculoOcupaPuesto = parqueadero.vehiculoOcupaPuesto(carro);

        //Verifica que el resultado sea verdado (true)
        assertTrue(vehiculoOcupaPuesto);

        System.out.println("Fin prueba de vehiculo ocupa Puesto");
    }

    @Test
    public void obtenerTarifaPorTipoVehiculoTest(){
        System.out.println("Inicio de prueba obtener tarifa por tipo de vehiculo");
        Parqueadero parqueadero = new Parqueadero("Te Lo Estacionamos", 100);

        //Establece las tarifas para los distintos tipos de vehiculos
        parqueadero.setTarifaMotoClasica(2.8);
        parqueadero.setTarifaMotoHibrida(3.0);
        parqueadero.setTarifaCarro(5.0);

        Vehiculo motoClasica = new Moto("CAN777", "Yamaha", new Propietario("Diana", "Garcia", "73939383"), 120, TipoMoto.CLASICA);
        Vehiculo motoHibrida = new Moto("DUN420", "Honda", new Propietario("Juan", "Diaz", "84839393"), 150, TipoMoto.HIBRIDA);
        Vehiculo carro = new Carro("DIS567", "Toyota", new Propietario("Nathali", "Alzate", "7838393"));

        //Obtiene las tarifas por cada tipo de vehiculo
        double tarifaCarro = parqueadero.obtenerTarifaPorTipoVehiculo(carro);
        double tarifaMotoClasica = parqueadero.obtenerTarifaPorTipoVehiculo(motoClasica);
        double tarifaMotoHibrida = parqueadero.obtenerTarifaPorTipoVehiculo(motoHibrida);

        //Verifica que las tarifas obtenidas sean las esperadas
        assertEquals(5.0, tarifaCarro);
        assertEquals(2.8, tarifaMotoClasica);
        assertEquals(3.0, tarifaMotoHibrida);

        System.out.println("Tarifa para carros: " + tarifaCarro);
        System.out.println("Tarifa para Motos Clasicas: " + tarifaMotoClasica);
        System.out.println("Tarifa para Motos Hibridas: " + tarifaMotoHibrida);
        System.out.println("Fin de prueba obtener tarifa por tipo de vehiculo");

    }


    @Test
    public void generarReporteMensual(){
        System.out.println("Inicio de prueba generar reporte mensual");

        Parqueadero parqueadero = new Parqueadero("Te Lo Estacionamos", 100);
        LocalDateTime fechaIngreso = LocalDateTime.now(); //obtiene la fecha y hora actual
        Vehiculo motoClasica = new Moto("CAN777", "Yamaha", new Propietario("Diana", "Garcia", "73939383"), 120, TipoMoto.CLASICA);
        Vehiculo motoHibrida = new Moto("DUN420", "Honda", new Propietario("Juan", "Diaz", "84839393"), 150, TipoMoto.HIBRIDA);
        Vehiculo carro = new Carro("DIS567", "Toyota", new Propietario("Nathali", "Alzate", "7838393"));

        parqueadero.registrarIngreso(motoClasica, 9,6);
        parqueadero.registrarIngreso(motoHibrida, 5,29);
        parqueadero.registrarIngreso(carro, 15,4);

        //Establece tarifas para los diferentes tipos de vehiculos
        parqueadero.setTarifaMotoClasica(2.8);
        parqueadero.setTarifaMotoHibrida(3.0);
        parqueadero.setTarifaCarro(5.0);

        parqueadero.generarReporteMensual(5,2024);

        assertEquals(2.8, parqueadero.getTarifaMotoClasica());
        assertEquals(3.0, parqueadero.getTarifaMotoHibrida());
        assertEquals(5.0, parqueadero.getTarifaCarro());

        System.out.println("Fin de prueba generar Reporte mensual");

    }


    @Test
    public void generarReporteDiarioo(){
        System.out.println("Inicio de prueba generar reporte diario");

        Parqueadero parqueadero = new Parqueadero("Te Lo Estacionamos", 100);
        Vehiculo motoClasica = new Moto("CAN777", "Yamaha", new Propietario("Diana", "Garcia", "73939383"), 120, TipoMoto.CLASICA);
        Vehiculo motoHibrida = new Moto("DUN420", "Honda", new Propietario("Juan", "Diaz", "84839393"), 150, TipoMoto.HIBRIDA);
        Vehiculo carro = new Carro("DIS567", "Toyota", new Propietario("Nathali", "Alzate", "7838393"));

        parqueadero.registrarIngreso(motoClasica, 9,6);
        parqueadero.registrarIngreso(motoHibrida, 5,29);
        parqueadero.registrarIngreso(carro, 15,4);

        //Establece tarifas para los diferentes tipos de vehiculos
        parqueadero.setTarifaMotoClasica(2.8);
        parqueadero.setTarifaMotoHibrida(3.0);
        parqueadero.setTarifaCarro(5.0);

        LocalDateTime fecha = LocalDateTime.now();
        parqueadero.generarReporteDiario(fecha);

        assertEquals(2.8, parqueadero.getTarifaMotoClasica());
        assertEquals(3.0, parqueadero.getTarifaMotoHibrida());
        assertEquals(5.0, parqueadero.getTarifaCarro());

        System.out.println("Fin de prueba generar Reporte diario");


    }
}