package com.example.trabajofinalprogramacion1;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * clase principal, maneja la ddministracion de puestos, vehiculos e ingresos
 */
public class Parqueadero {

    private String nombre;
    private Puesto[][] matrizPuestos;
    private List<Vehiculo> listVehiculos;
    private List<Ingreso> listIngresos;
    private double tarifaMotoClasica; // tarifa por hora
    private double tarifaMotoHibrida;
    private double tarifaCarro;

    /**
     * constructor de la clase Parqueadero
     *
     * @param nombre
     * @param numeroPuesto
     */
    public Parqueadero(String nombre, int numeroPuesto) {
       assert nombre != null;

        this.nombre = nombre;
        this.matrizPuestos = new Puesto [100][100];
        this.listVehiculos = new ArrayList<>();
        this.listIngresos = new ArrayList<>();


        //Inicializamos la matriz de puestos
        for(int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                matrizPuestos[i][j] = new Puesto(i,j); //creacion de nuevo puesto
            }
        }
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

    public Puesto[][] getMatrizPuestos() {
        return matrizPuestos;
    }

    public void setMatrizPuestos(Puesto[][] matrizPuestos) {
        this.matrizPuestos = matrizPuestos;
    }

    public List<Vehiculo> getListVehiculos() {
        return listVehiculos;
    }

    public void setListVehiculos(List<Vehiculo> listVehiculos) {
        this.listVehiculos = listVehiculos;
    }

    public List<Ingreso> getListIngresos() {
        return listIngresos;
    }

    public void setListIngresos(List<Ingreso> listIngresos) {
        this.listIngresos = listIngresos;
    }

    public double getTarifaMotoClasica() {
        return tarifaMotoClasica;
    }

    public void setTarifaMotoClasica(double tarifaMotoClasica) {
        this.tarifaMotoClasica = tarifaMotoClasica;
    }

    public double getTarifaMotoHibrida() {
        return tarifaMotoHibrida;
    }

    public void setTarifaMotoHibrida(double tarifaMotoHibrida) {
        this.tarifaMotoHibrida = tarifaMotoHibrida;
    }

    public double getTarifaCarro() {
        return tarifaCarro;
    }

    public void setTarifaCarro(double tarifaCarro) {
        this.tarifaCarro = tarifaCarro;
    }

    /**
     * Encuntra un puesto en el parqueadero dado su posicion (i,j)
     * @param i
     * @param j
     * @return
     */
    public Puesto encontrarPuesto(int i, int j) {
        //Verifica que las coordenada esten dentro del rango de la matriz
        if (i >= 0 && i < 100 && j >= 0 && j < 100){
            return matrizPuestos[i][j];
        } else {
            System.out.println("Error, la posicion esta fuera del rango");
            return null; //Retorna null si las coordenadas estan fuera del rango
        }
    }


    /**
     * Verifica la disponibilidad de un puesto en el parqueadero dado su posicion (i,j)
     * @param i
     * @param j
     * @return
     */
    public boolean verificarDisponibilidadPusto(int i, int j) {
        //Verifica que las coordenadas esten dentro del rango de la matriz
        if (i >= 0 && i < 100 && j >= 0 && j <100){
            Puesto puesto = matrizPuestos[i][j]; //Obtiene el puesto en las coordenadas dadas
            return !puesto.estaOcupado(); //Devuelve true si el puesto no esta ocupado
        } else {
            System.out.println("las Coordenadas estan fuera del rango");
            return false; //devuelve false si las coordenadas estan fuera del rango
        }
    }


    /**
     * Registra el ingreso de un vehiculo al parqueadero en un puesto especificado
     * @param vehiculo
     * @param i
     * @param j
     */
    public void registrarIngreso(Vehiculo vehiculo, int i, int j) {
        //Verifica si las coordenadas estan dentro del rango de la matriz de puestos
        if (i >= 0 && i < 100 && j >=0 && j < 100){
            Puesto puesto = matrizPuestos[i][j]; //Obtener el puesto de las coordenadas especificas
            if (!puesto.estaOcupado()){ //Verifica si el puesto esta disponible
                puesto.setVehiculo(vehiculo); //Asigna el vehiculo al puesto
                listVehiculos.add(vehiculo);
                listIngresos.add(new Ingreso(puesto, vehiculo)); //Registra el ingreso en la lista de ingresos
                System.out.println("Ingreso registrado correctamente en el puesto (" + i + ", " + j + ")" );
            } else {
                System.out.println("El Puesto en las coordenadas (" + i + ", " + j + ") Esta ocupado");
            }
        } else {
            System.out.println("Las coordenadas especificadas estan fuera del rango de la matriz de puestos");
        }
    }


    /**
     * Registra la salida de un vehiculo
     * @param vehiculo
     */
    public void registrarSalida (Vehiculo vehiculo){
        for (Ingreso ingreso : listIngresos){
            if (ingreso.getVehiculo().equals(vehiculo)){ //Comprueba si el vehiculo esa en la lista de ingresos
                ingreso.setFechaSalida(LocalDateTime.now()); //Establece la fecha de salida como la fecha y hora actual
                listIngresos.remove(ingreso);
                System.out.println("Salida registrada");
            }
        }
        System.out.println("Error, vehiculo no encontrado en ingresos");
    }


    /**
     * Identifica al propietario del vehiculo en un puesto dado
     * @param i
     * @param j
     * @return
     */
    public Propietario identificarPropietario(int i, int j) {
        Puesto puesto = encontrarPuesto(i,j); //obtiene el puesto en las coordenadas dadas
        if (puesto != null && puesto.estaOcupado()){
            return puesto.getVehiculo().getPropietario();
        } else {
            System.out.println("Error, no hay vehiculo en el puesto especificado");
            return null;
        }
    }


    /**
     * Calcula el costo de estacionamiento para un vehiculo desde su ingreso hasta su salida
     * @param vehiculo
     * @param fechaSalida
     * @return
     */
    public double calcularCostoEstacionamiento(Vehiculo vehiculo, LocalDateTime fechaSalida) {
        for (Ingreso ingreso : listIngresos) { //Recorre la lista de ingresos
            if (ingreso.getVehiculo().equals(vehiculo)) { //Comprueba si el vehiculo esta en algun ingreso
                LocalDateTime fechaIngreso = ingreso.getFechaIngreso();
                long horasEstacionadas = java.time.Duration.between(fechaIngreso, fechaSalida).toHours(); //Calcula las horas de estacionamiento
                double tarifa = obtenerTarifaPorTipoVehiculo(vehiculo);
                double costo = tarifa * horasEstacionadas;
                System.out.println("Costo de estacionamiento: " + costo);
                return costo;
            }
        }
        System.out.println("Error, vehiculo no encontrado en los ingresos");
        return 0; //Devuelve 0 si el vehiculo no se encuntra en los ingresos
    }


    /**
     * Devuelve la tarifa por hora del tipo de vehiculo
     * @param vehiculo
     * @return
     */
    public double obtenerTarifaPorTipoVehiculo(Vehiculo vehiculo){
        if (vehiculo instanceof Moto){
            Moto moto = (Moto) vehiculo;
            if (moto.getTipoMoto() == TipoMoto.CLASICA){
                return tarifaMotoClasica;
            } else {
                return tarifaMotoHibrida;
            }
        } else if (vehiculo instanceof Carro) {
            return tarifaCarro;
        }
        System.out.println("Error, tipo de vehiculo desconocido");
        return 0; //Devuelve 0 si el tipo de vehiculo es desconocido
    }


    /**
     * Verifica si un vehiculo esta ocupando algun puesto en el parqueadero
     * @param vehiculo
     * @return
     */
    public boolean vehiculoOcupaPuesto(Vehiculo vehiculo){
        for (Puesto[] fila : matrizPuestos){
            for (Puesto puesto : fila){
                if (puesto.estaOcupado() && puesto.getVehiculo().equals(vehiculo)){
                    return true;
                }
            }
        }
        System.out.println("El vehiculo no ocupa ningun puesto");
        return false;
    }

    /**
     * Genera un reporte diario del parqueadero para una fecha especifica
     * @param fecha
     */
    public void generarReporteDiario(LocalDateTime fecha) {
        double totalMotoClasica = 0;
        double totalMotoHibrida = 0;
        double totalCarro = 0;

        for (Ingreso ingreso : listIngresos){
            LocalDateTime fechaSalida = ingreso.getFechaSalida();

            if (fechaSalida != null && fechaSalida.toLocalDate().isEqual(fecha.toLocalDate())){
                Vehiculo vehiculo = ingreso.getVehiculo();
                double costo = calcularCostoEstacionamiento(vehiculo, fechaSalida);

                if (vehiculo instanceof  Moto){
                    Moto moto = (Moto) vehiculo;
                    if (moto.getTipoMoto() == TipoMoto.CLASICA){
                        totalMotoClasica += costo;
                    } else {
                        totalMotoHibrida += costo;
                    }
                } else if (vehiculo instanceof Carro) {
                    totalCarro += costo;
                }
            }
        }
        System.out.println("Reporte Diario - " + fecha );
        System.out.println("Total Recaudado Moto Clasica: " + totalMotoClasica);
        System.out.println("Total Recaudo Moto Hibrida: " + totalMotoHibrida);
        System.out.println("Total Recaudo Carro: " + totalCarro);
    }

    /**
     * Genera un reporte mensual del parqueadero para un mes y un año especifico
     * @param mes
     * @param anio
     * @return
     */
    public void generarReporteMensual(int mes, int anio) {
        double totalMotoClasica = 0;
        double totalMotoHibrida = 0;
        double totalCarro = 0;

        LocalDate primerDiaMes = LocalDate.of(anio, mes, 1);
        LocalDate ultimoDiaMes = primerDiaMes.withDayOfMonth(primerDiaMes.lengthOfMonth());

        //Iterar sobre los ingresos para calcular el total recaudado por tipo de vehiculo
        for (Ingreso ingreso : listIngresos){
            LocalDateTime fechaSalida = ingreso.getFechaSalida();

            if (fechaSalida != null){
                LocalDate fechaSalidaa = fechaSalida.toLocalDate();

                if (fechaSalidaa.getMonthValue() == mes && fechaSalidaa.getYear() == anio){
                    Vehiculo vehiculo = ingreso.getVehiculo();
                    double costo = calcularCostoEstacionamiento(vehiculo, fechaSalida);


                    if (vehiculo instanceof Moto){
                        Moto moto = (Moto) vehiculo;
                        if (moto.getTipoMoto() == TipoMoto.CLASICA){
                            totalMotoClasica += costo;
                        } else {
                            totalMotoHibrida += costo;
                        }
                    } else if (vehiculo instanceof Carro) {
                        totalCarro += costo;

                    }
                }
            }
        }
        System.out.println("Reporte Mensual: ");
        System.out.println("Mes: " + mes + " Año: " + anio);
        System.out.println("Total recaudado por moto clasica: " + totalMotoClasica);
        System.out.println("Total recaudado por moto Hibrida: " + totalMotoHibrida);
        System.out.println("Total recaudado por Carro: " + totalCarro);
    }


}
