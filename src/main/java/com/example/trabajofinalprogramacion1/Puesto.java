package com.example.trabajofinalprogramacion1;

// clase que representa un puesto en el estacionamiento

public class Puesto {

    private int i;
    private int j;
    private Vehiculo vehiculo; // vehiculo en el puesto

    /**
     * constructor de la clase Puesto
     * @param i
     * @param j
     */
    public Puesto(int i, int j) {
        assert i >= 0;
        assert j >= 0;

        this.i = i;
        this.j = j;
        this.vehiculo = null; //Inicialmente el puesto esta vacio
    }

    /**
     *
     * Getters y Setters
     */

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }


    /**
     * verifica si el puesto esta ocupado
     * @return true si el puesto esta ocupado, false de lo contrario
     */
    public boolean estaOcupado(){
        return this.vehiculo != null;
    }

    /**
     * metodo para asignar un vehiculo al puesto
     * @param vehiculo
     */
    public void asignarVehiculo(Vehiculo vehiculo){
        if (!estaOcupado()){
            this.vehiculo = vehiculo;
            System.out.println("Vehiculo asignado al puesto");
        } else {
            System.out.println("Error, el puesto ya esta ocupado");
        }
    }

    /**
     * retorna el vehiculo ubicado en el puesto
     * @return
     */
    public Vehiculo getVehiculo(){
        return  vehiculo;
    }

    /**
     * desocupa el puesto, retirando el vehiculo
     */
    public void desocupar(){
        if(estaOcupado()){
            this.vehiculo = null; //Establece el vehiculo del puesto como null, por ende queda desocupado el puesto
            System.out.println("Puesto desocupado");
        } else {
            System.out.println("El puesto ya esta desocupado");
        }
    }
}
